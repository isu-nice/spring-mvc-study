package hello.springmvc.basic;

import lombok.Data;

/*
 * @Data 는 @Getter, @Setter, @ToString,
 * @EqualsAndHashCode, @RequiredArgsConstructor를 자동으로 적용해줌
 */
@Data
public class HelloData {
    private String username;
    private int age;
}
