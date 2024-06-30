package br.com.chronicles.buillders;

import br.com.chronicles.model.entity.FileWork;

public interface FileWorkBuilder {

    FileWorkBuilder withName(String name);

    FileWorkBuilder withData(byte[] data);

    FileWork build();
}
