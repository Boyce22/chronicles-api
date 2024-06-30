package br.com.chronicles.service;

import br.com.chronicles.interfaces.ReaderService;
import br.com.chronicles.model.entity.Reader;
import br.com.chronicles.model.request.ReaderRegisterDTO;
import br.com.chronicles.model.request.ReaderUpdateDTO;
import br.com.chronicles.model.response.ReaderDetailsDTO;
import br.com.chronicles.repository.ReaderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReaderServiceImpl implements ReaderService {

    private final ReaderRepository readerRepository;

    public ReaderServiceImpl(ReaderRepository readerRepository) {
        this.readerRepository = readerRepository;
    }

    @Override
    public List<ReaderDetailsDTO> findAll() {
        return readerRepository.findAllActive().stream().map(ReaderDetailsDTO::new).toList();
    }

    @Override
    public void delete(Long id) {
        Reader reader = findById(id);
        readerRepository.save(Reader.update(reader).disable().build());
    }

    @Override
    public void deletePermanently(Long id) {
        readerRepository.delete(findById(id));
    }

    @Override
    public ReaderDetailsDTO update(ReaderUpdateDTO dto, Long id) {
        Reader reader = findById(id);

        Reader readerUpdated = Reader
                .update(reader)
                .withName(dto.name())
                .withLastName(dto.lastName())
                .withEmail(dto.email())
                .withBirthDate(dto.birthDate())
                .build();

        return new ReaderDetailsDTO(readerRepository.save(readerUpdated));
    }

    @Override
    public ReaderDetailsDTO register(ReaderRegisterDTO dto) {
        Reader reader = Reader
                .builder()
                .withName(dto.name())
                .withLastName(dto.lastName())
                .withEmail(dto.email())
                .withBirthDate(dto.birthDate())
                .build();

        return new ReaderDetailsDTO(readerRepository.save(reader));
    }

    @Override
    public void active(Long id) {
        Reader reader = findById(id);
        readerRepository.save(Reader.update(reader).active().build());
    }

    @Override
    public Reader findById(Long id) {
        return readerRepository.findById(id).orElseThrow(() -> new RuntimeException("Leitor não encontrado"));
    }

}
