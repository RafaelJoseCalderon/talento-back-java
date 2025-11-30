package org.talento.java.mappers;

import org.mapstruct.Mapper;
import org.talento.java.dtos.user.UserRes;
import org.talento.java.models.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserRes toDto(User product);
}
