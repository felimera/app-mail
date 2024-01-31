package com.project.appmail.service.mapper;

import com.project.appmail.model.MailStructure;
import com.project.appmail.model.dto.MailStructureDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MailStructureMapper {

    MailStructureMapper INSTANCE = Mappers.getMapper(MailStructureMapper.class);

    MailStructure fromDomainModel(MailStructureDTO dto);

    @InheritInverseConfiguration
    MailStructureDTO toDomainModel(MailStructure entity);
}
