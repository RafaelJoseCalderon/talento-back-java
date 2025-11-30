package org.talento.java.dtos;

import org.springframework.data.domain.Page;
import java.util.List;

public record PageRes<T>(
    List<T> content,
    String query,
    Pagination pagination
) {
    public PageRes(String query, Page<T> page) {
        this(page.getContent(), query, new Pagination(page));
    }

    public record Pagination(
        int page,
        int size,
        int totalPages
    ) {
        public Pagination(Page<?> page) {
            this(page.getNumber(), page.getSize(), page.getTotalPages());
        }
    }
}
