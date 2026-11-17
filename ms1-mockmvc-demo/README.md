# Unit Testing Controller Endpoints with MockMvc (MS1Controller)

## Project Structure
- `MS1Controller.java`: REST controller under `/ms1` handling arithmetic (`/ms1/add`, `/ms1/subtract`) and user management (`/ms1/users`).
- `UserService.java`: Service dependency injected into `MS1Controller`.
- `MS1ControllerTest.java`: Isolated web-layer unit test annotated with `@WebMvcTest(MS1Controller.class)` using `MockMvc` and `@MockitoBean`.

## How to Import & Run in STS4 / Eclipse
1. Extract this ZIP file.
2. Open **Spring Tool Suite 4 (STS4)** or **Eclipse**.
3. Go to **File -> Import -> Maven -> Existing Maven Projects**, select the extracted `ms1-mockmvc-demo` folder, and click **Finish**.
4. Right-click `MS1ControllerTest.java` -> **Run As -> JUnit Test**.
5. Verify that `testAddEndpoint` passes with HTTP `200 OK` and response body `"MS 1.1 - Additon = 15"`.
