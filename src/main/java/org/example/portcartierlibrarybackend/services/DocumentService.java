package org.example.portcartierlibrarybackend.services;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.example.portcartierlibrarybackend.model.Document;
import org.example.portcartierlibrarybackend.repository.DocumentRepository;
import org.example.portcartierlibrarybackend.tools.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.ObjectError;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DocumentService {
    @Autowired
    private DocumentRepository documentRepository;

    public boolean createDocument(String author, String category, String date,String description, String genre, String title, String type, String ISBM) {
        Document newDocument = new Document();
        newDocument.setAuthor(author);
        newDocument.setCategory(category);
        newDocument.setYear(date);
        newDocument.setDescription(description);
        newDocument.setGenre(genre);
        newDocument.setTitle(title);
        newDocument.setType(type);
        if (ISBM != null){
            newDocument.setISBM(ISBM);
        }
        documentRepository.save(newDocument);
        return true;
    }
    public ObjectNode searchDocument(String keyword,String type){
        ObjectNode response = Json.createNode();
        List<Document> search = List.of();
        switch (type) {
            case "code":
                try{
                    Long id = Long.parseLong(keyword);
                    Optional<Document> searchId = documentRepository.findById(id);
                    if(searchId.isPresent()){
                        ObjectNode documentObject = Json.createNode();
                        documentObject.put("title", searchId.get().getTitle());
                        response.put(searchId.get().getTitle(), documentObject);
                    }
                }catch(Exception e){
                    response.put("error", "id need to be number");
                }
                break;
            case "title":
                search = documentRepository.findByTitleContainingIgnoreCase(keyword);
                break;
            case "author":
                search = documentRepository.findByAuthorContainingIgnoreCase(keyword);
                break;
            case "year":
                search = documentRepository.findByYearContainingIgnoreCase(keyword);
                break;
            case "category":
                search = documentRepository.findByCategoryContainingIgnoreCase(keyword);
                break;
            case "type":
                search = documentRepository.findByTypeContainingIgnoreCase(keyword);
                break;
            case "genre":
                search = documentRepository.findByGenreContainingIgnoreCase(keyword);
                break;
            case "description":
                search = documentRepository.findByDescriptionContainingIgnoreCase(keyword);
                break;
            case "isbn":
                break;
        }
        if(!search.isEmpty() || !type.equals("id")){
            search.forEach(document -> {
                ObjectNode documentObject = Json.createNode();
                documentObject.put("title", document.getTitle());
                response.put(document.getId().toString(), documentObject);
            });
        }else{
            response.put("error", "No Documents Found");
        }
        return response;
    }

    public ObjectNode getDocument(Long id){
        ObjectNode response = Json.createNode();
        Optional<Document> result = documentRepository.findById(id);
        if(result.isPresent()){
            response.put("id", result.get().getId().toString() );
            response.put("title", result.get().getTitle());
            response.put("author", result.get().getAuthor());
            response.put("year", result.get().getYear());
            response.put("category", result.get().getCategory());
            response.put("type", result.get().getType());
            response.put("genre", result.get().getGenre());
            response.put("description", result.get().getDescription());
            response.put("isbn", result.get().getISBM());
            response.put("reserved", result.get().isReserved());
        }else{
            response.put("error", "No Documents Found");
        }
        return response;
    }
    public boolean requestDocument(Long id, String member){
        Optional<Document> result = documentRepository.findById(id);
        if(result.isPresent()){
            result.get().setReserved(true);
            result.get().setAuthor(member);
            documentRepository.save(result.get());
            return true;
        }
        return false;
    }
    public ObjectNode allDocument(){
        ObjectNode response = Json.createNode();
        List<Document> all = documentRepository.findAll();
        if(!all.isEmpty()){
            all.forEach(document -> {
                ObjectNode documentObject = Json.createNode();
                documentObject.put("title", document.getTitle());
                documentObject.put("author", document.getAuthor());
                documentObject.put("genre", document.getGenre());
                documentObject.put("type", document.getType());
                response.put(document.getId().toString(), documentObject);
            });
        }else{
            response.put("error", "No Documents Found");
        }
        return response;
    }
}

