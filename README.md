# Review_JavaSpringBoot
9:36PM 10/5/2026 start





Kho file jar Maven kéo về :https://mvnrepository.com/




cách viết tuân thủ 13 practice tài liệu link: https://florimond.dev/en/posts/2018/08/restful-api-design-13-best-practices-to-make-your-users-happy



- tài liệu sách dạy custom Exception: trang Exception javapoint


- tài liệu để fix lỗi bị lỗi sever những vẫn trả về 200 OK 
-@ControllerAdvice 
- link: https://zetcode.com/springboot/controlleradvice/

- phân biệt rõ lỗi 401 và 403 khác nhau chỗ nào ?

+ 401:Mặc dù tiêu chuẩn HTTP quy định "unauthorized" (không được phép), về mặt ngữ nghĩa, phản hồi này
có nghĩa là "unauthenticated" (chưa được xác thực). Tức là, máy khách phải
tự xác thực để nhận được phản hồi yêu cầu.

+ 401: Sai Tài Khoản đăng nhập hoặc quá thời hạn đăng nhập.


+ 403:Máy khách không có quyền truy cập vào nội dung; tức là,
việc truy cập là trái phép, vì vậy máy chủ từ chối cung cấp tài nguyên được yêu cầu.
Không giống như các trường hợp khác 401 Unauthorized, danh tính của máy khách được máy chủ biết đến.
Máy khách không có quyền truy cập vào nội dung; tức là, việc truy cập là trái phép,
vì vậy máy chủ từ chối cung cấp tài nguyên được yêu cầu. Không giống như các trường hợp khác 401 Unauthorized,
danh tính của máy khách được máy chủ biết đến.

+ 403: Đăng nhập thành công nhưng tài khoản đang truy cập 1 API chưa được phân quyền.


- Kết nối jdbc với my SQL

   // static final String DB_URL = "jdbc:mysql://localhost:3306/estatebasic";
    static final String USER = "root";
    static final String PASS = "123456";
  //
