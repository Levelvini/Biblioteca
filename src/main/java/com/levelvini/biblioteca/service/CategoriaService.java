package com.levelvini.biblioteca.service;

import com.levelvini.biblioteca.exceptions.EmptyDataException;
import com.levelvini.biblioteca.exceptions.ResourceNotFoundException;
import com.levelvini.biblioteca.model.Categoria;
import com.levelvini.biblioteca.model.DTO.CategoriaDTO;
import com.levelvini.biblioteca.repository.CategoriaRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    public CategoriaRepository categoriaRepository;
    public ModelMapper modelMapper;

    @Autowired
    public CategoriaService(CategoriaRepository categoriaRepository, ModelMapper modelMapper) {
        this.categoriaRepository = categoriaRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public List<CategoriaDTO> getAll(){
        List<Categoria> categorias = categoriaRepository.findAll();
        if (categorias.isEmpty()){
            throw new EmptyDataException("você ainda não possui categorias cadastradas");
        }else {
            return Collections.singletonList(modelMapper.map(categorias, CategoriaDTO.class));
        }
    }

    @Transactional
    public Optional<CategoriaDTO> getById(Long id){
       Categoria categoria = categoriaRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("a categoria não pôde ser encontrada"));
       return Optional.ofNullable(modelMapper.map(categoria, CategoriaDTO.class));
    }

    @Transactional
    public Categoria save(CategoriaDTO categoriaDTO){
        Categoria categoria = modelMapper.map(categoriaDTO, Categoria.class);
        return categoriaRepository.save(categoria);
    }

    @Transactional
    public Categoria update(Long id, CategoriaDTO categoriaDTO){
        Categoria categoria = categoriaRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("o objeto a ser atualiza não foi encontrado"));
        modelMapper.map(categoriaDTO, categoria);
        return categoriaRepository.save(categoria);
    }

    @Transactional
    public void delete(Long id){
        Categoria categoria = categoriaRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("a categoria não foi encontrada"));
        categoriaRepository.delete(categoria);
    }
}
