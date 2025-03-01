package pl.qc.spring.rest.dto;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BookItem {

    private Long id;
    private String title;
    private String author;
    private String isbn;
    private int year;
}
