package com.example.repository;

import com.example.model.Language;

import java.util.List;

public interface ILanguageRepository {
    List<Language> display();

    Language findID(int id);

    List<String> displayName();

    List<Integer> displaySize();

    void update(Language language,int id);
}
