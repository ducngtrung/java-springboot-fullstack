package baikiemtra.usermanager.response;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserListPagination {
    private List<UserInfoResponse> data;
    private int currentPage;
    private int size;
    private int totalPage;
}