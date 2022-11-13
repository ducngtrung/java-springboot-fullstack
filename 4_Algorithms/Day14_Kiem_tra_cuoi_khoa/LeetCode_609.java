import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

// Given a list paths of directory info, including the directory path, and all the files with contents in this directory, return all the duplicate files in the file system in terms of their paths. You may return the answer in any order.

public class LeetCode_609 {
    public static void main(String[] args) {
        String[] paths = {
            "root/a 1.txt(abcd) 2.txt(efgh)",
            "root/c 3.txt(abcd)",
            "root/c/d 4.txt(efgh)",
            "root 4.txt(efgh)"
        };
        // String[] paths = {
        //     "root/a 1.txt(abcd) 2.txt(efgh)",
        //     "root/c 3.txt(abcd)",
        //     "root/c/d 4.txt(efgh)"
        // };

        System.out.println(findDuplicate(paths));
    }

    static List<List<String>> findDuplicate(String[] paths) {
        // Tạo map với key là file content, value là list các file path có cùng file content
        Map<String, List<String>> map = new HashMap<>();

        for (String path : paths){
            // Tách chuỗi ban đầu theo ký tự space ' '
            String[] segments = path.split(" ");
            
            // Lấy ra file directory
            String directory = segments[0]; // VD: root/c/d

            // Duyệt từng file (gồm file name và file content)
            for (int i = 1; i < segments.length; ++i){
                String nameAndContent = segments[i]; // VD: 1.txt(abcd)

                // Lấy ra file content (substring nằm trong cặp ký tự '(' ')' )
                String fileContent = nameAndContent.substring(nameAndContent.indexOf('('),nameAndContent.indexOf(')'));

                // Lấy ra file name (substring nằm phía trước ký tự '(' )
                String fileName = nameAndContent.substring(0,nameAndContent.indexOf('('));

                // Lấy ra file path dưới dạng "directory/fileName"
                String filePath = directory + "/" + fileName;

                List<String> pathList = new ArrayList<>();
                // Nếu đã tồn tại fileContent như một key trong map thì gán list path hiện tại cho pathList
                if (map.containsKey(fileContent)) {
                    pathList = map.get(fileContent);
                }
                // Thêm filePath vào pathList
                pathList.add(filePath);

                // Thêm entry vào map, nếu đã tồn tại fileContent như một key trong map thì ghi đè pathList mới nhất vào value
                map.put(fileContent, pathList);
            }
        }

        List<List<String>> result = new ArrayList<>();
        for (String fileContent : map.keySet()){
            // Nếu pathList chứa từ 2 phần tử trở lên (có duplicate file content) thì add vào list result
            if (map.get(fileContent).size() > 1) {
                result.add(map.get(fileContent));
            }
        }
        return result;
    }
}