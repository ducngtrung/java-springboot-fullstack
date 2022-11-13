import java.util.HashSet;
import java.util.Set;

// Given an array of strings emails where we send one email to each emails[i], return the number of different addresses that actually receive mails.

public class LeetCode_929 {
    public static void main(String[] args) {
        String[] emails = {
            "test.email+alex@leetcode.com",
            "test.e.mail+bob.cathy@leetcode.com",
            "testemail+david@lee.tcode.com"
        };
        // String[] emails = {
        //     "test.email+alex@leetcode.com",
        //     "test.email.leet+alex@code.com"
        // };

        System.out.println(numUniqueEmails(emails));
    }

    static int numUniqueEmails(String[] emails) {
        Set<String> emailSet = new HashSet<>();

        for (String email : emails) {
            // Tách mỗi chuỗi thành mảng chứa local name và domain name
            String[] localAndDomain = email.split("@");

            // Lấy ra local name, sau đó xóa ký tự '.' và xóa các ký tự tính từ '+' trở đi 
            String localName = localAndDomain[0].replaceAll("\\.", "").replaceAll("\\+.*","");

            // Tạo chuỗi chứa email sau khi được format lại
            StringBuilder fmtEmail = new StringBuilder();
            fmtEmail.append(localName);
            fmtEmail.append("@");
            fmtEmail.append(localAndDomain[1]);

            // Thêm formatted email vào set
            emailSet.add(fmtEmail.toString());
        }
        return emailSet.size();
    }
}