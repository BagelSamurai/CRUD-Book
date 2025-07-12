package com.example.bookrest.LibraryService;

import com.example.bookrest.model.Book;
import com.example.bookrest.model.BorrowingRecord;
import com.example.bookrest.model.Member;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class LibraryService {

    // In-memory storage using ArrayList
    private List<Book> books = new ArrayList<>();
    private List<Member> members = new ArrayList<>();
    private List<BorrowingRecord> borrowingRecords = new ArrayList<>();

    // === BOOK METHODS ===

    // Get all books
    public List<Book> getAllBooks() {
        return books;
    }

    // Get a book by ID
    public Optional<Book> getBookById(Long id) {
        return books.stream().filter(book -> book.getId().equals(id)).findFirst();
    }

    // Add a new book
    public void addBook(Book book) {
        books.add(book);
    }
    // Update a book
    public void updateBook(Book book) {
        books.set(books.indexOf(book), book);
    }
    // Delete a book
    public void deleteBook(Long id) {
        books.removeIf(book -> book.getId().equals(id));
    }
    // ==================== Member Methods ====================
    // Get all members
    public List<Member> getAllMembers() {
        return members;
    }
    // Get a member by ID
    public Optional<Member> getMemberById(Long id) {
        return members.stream()
                .filter(member -> member.getId().equals(id))
                .findFirst();
    }
    // Add a new member
    public void addMember(Member member) {
        members.add(member);
    }
    // Update a member
    public void updateMember(Member updatedMember) {
        for (int i = 0; i < members.size(); i++) {
            Member member = members.get(i);
            if (member.getId().equals(updatedMember.getId())) {
                members.set(i, updatedMember);
                break;
            }
        }
    }
    // Delete a member by ID
    public void deleteMember(Long id) {
        members.removeIf(member -> member.getId().equals(id));
    }

// ==================== BorrowingRecord Methods ====================

    // Get all borrowing records
    public List<BorrowingRecord> getAllBorrowingRecords() {
        return borrowingRecords;
    }

    // Borrow a book
    public void borrowBook(BorrowingRecord record){
        record.setBorrowDate(LocalDate.now());
        record.setDueDate(LocalDate.now().plusDays(14));
        borrowingRecords.add(record);
        // Decrease
        Book book = record.getBook();
        book.setAvailableCopies(book.getAvailableCopies()-1);

    }
    public void returnBook(Long recordId, LocalDate returnDate){
        for(BorrowingRecord record : borrowingRecords){
            if(record.getId().equals(recordId)){
                record.setReturnDate(returnDate);

                Book book = record.getBook();
                book.setAvailableCopies(book.getAvailableCopies()+1);
                break;
            }
        }

    }
}