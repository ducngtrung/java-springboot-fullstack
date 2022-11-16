package baikiemtra.usermanager.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserListPagination {
    private List<UserInfoResponse> data;
    private int currentPage;
    private int size;
    private int totalPage;
}
