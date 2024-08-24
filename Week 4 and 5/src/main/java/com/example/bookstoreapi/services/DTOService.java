package com.example.bookstoreapi.services;

import com.example.bookstoreapi.dto.BookDTO;
import com.example.bookstoreapi.dto.CustomerDTO;
import com.example.bookstoreapi.model.Book;
import com.example.bookstoreapi.model.Customer;
import java.awt.print.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DTOService {

    @Autowired
    private ModelMapper modelMapper;

    public BookDTO convertToDTO(Book book) {
        return modelMapper.map(book, BookDTO.class);
    }

    public CustomerDTO convertToDTO(Customer customer) {
        return modelMapper.map(customer, CustomerDTO.class);
    }

    public Book convertToEntity(BookDTO bookDTO) {
        return modelMapper.map(bookDTO, Book.class);
    }

    public Customer convertToEntity(CustomerDTO customerDTO) {
        return modelMapper.map(customerDTO, Customer.class);
    }
}
