package br.com.chronicles.service;

import br.com.chronicles.interfaces.AccountService;
import br.com.chronicles.interfaces.CollaboratorService;
import br.com.chronicles.interfaces.ReaderService;
import br.com.chronicles.model.entity.Reader;
import br.com.chronicles.model.request.ReaderChangeRequestDTO;
import br.com.chronicles.model.response.CollaboratorDetailsDTO;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private final CollaboratorService collaboratorService;

    private final ReaderService readerService;

    public AccountServiceImpl(CollaboratorService collaboratorService, ReaderService readerService) {
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
