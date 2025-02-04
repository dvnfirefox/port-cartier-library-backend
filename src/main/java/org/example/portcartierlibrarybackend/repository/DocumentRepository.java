package org.example.portcartierlibrarybackend.repository;

import org.example.portcartierlibrarybackend.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
    List<Document> findByDescriptionContainingIgnoreCase(String keyword);

    List<Document> findByGenreContainingIgnoreCase(String keyword);

    List<Document> findByTypeContainingIgnoreCase(String keyword);

    List<Document> findByCategoryContainingIgnoreCase(String category);

    List<Document> findByYearContainingIgnoreCase(String year);

    List<Document> findByAuthorContainingIgnoreCase(String author);

    List<Document> findByTitleContainingIgnoreCase(String title);

    Optional<Document> findById(Long id);
}
