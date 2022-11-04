package com.lusacramento.lslog.assembler;

import com.lusacramento.lslog.domain.model.dto.EntregaDto;
import com.lusacramento.lslog.domain.model.entity.Entrega;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EntregaAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public EntregaDto toDto(Entrega entrega){
        return modelMapper.map(entrega, EntregaDto.class);
    }

    public List<EntregaDto> toCollectionDto(List<Entrega> entregas){
        return entregas.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }


}
