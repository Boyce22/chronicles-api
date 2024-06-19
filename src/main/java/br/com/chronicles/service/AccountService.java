package br.com.chronicles.service;

import br.com.chronicles.interfaces.AccountServiceImpl;
import br.com.chronicles.interfaces.CollaboratorServiceImpl;
import br.com.chronicles.interfaces.ReaderServiceImpl;
import br.com.chronicles.model.entity.Reader;
import br.com.chronicles.model.request.ReaderChangeRequestDTO;
import br.com.chronicles.model.response.CollaboratorDetailsDTO;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements AccountServiceImpl {

    private final CollaboratorServiceImpl collaboratorService;

    private final ReaderServiceImpl readerService;

    public AccountService(CollaboratorServiceImpl collaboratorService, ReaderServiceImpl readerService) {
        this.collaboratorService = collaboratorService;
        this.readerService = readerService;
    }

    @Override
    @Transactional
    public CollaboratorDetailsDTO grantAuthorAccessToReader(Long id, ReaderChangeRequestDTO dto) {
        Reader reader = findById(id);
        CollaboratorDetailsDTO author = collaboratorService.grantAuthorAccess(reader, dto);
        readerService.deletePermanently(id);
        return author;
    }

    private Reader findById(Long readerId) {
        return readerService.findById(readerId);
    }

}
