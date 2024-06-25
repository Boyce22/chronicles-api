package br.com.chronicles.interfaces;

import br.com.chronicles.model.entity.Chapter;
import br.com.chronicles.model.entity.FileWork;

import java.io.IOException;

public interface ChapterServiceImpl {

    Chapter save(FileWork fileWork, String title, String description) throws IOException;
}
