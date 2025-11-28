# Selenium_Testing — Project Documentation

## Overview

Selenium_Testing is a Java + Maven automated UI test project that uses the Page Object Model (POM) to test various demo pages (alerts, context menus, dropdowns, uploads, frames, etc.). Tests live under `src/test/java` and page objects under `src/main/java/com/auth/pages`. This document helps a new contributor set up, run, and extend the test suite.

---

## Quick checklist (what I'll cover)
- [x] Prerequisites and environment notes
- [x] Quick setup commands (macOS zsh examples)
- [x] Project layout and test conventions
- [x] Page Object mapping (one-line descriptions)
- [x] How to run tests (Maven + IntelliJ examples)
- [x] Screenshots and resources guidance
- [x] Troubleshooting and next steps

---

## 1) Prerequisites

- JDK: Use an LTS release such as Java 11 or Java 17 (both are commonly supported). Ensure JAVA_HOME is set to the JDK installation.
- Maven: Apache Maven (3.6+ recommended). Verify with `mvn -v`.
- Browser driver(s): ChromeDriver for Chrome, geckodriver for Firefox. Driver binary versions should match the installed browser version.
- Optional: WebDriverManager (library) can be added to automatically download matching drivers.

macOS (zsh) notes:
- Add driver binaries to a PATH location (or install via Homebrew):

```bash
# Example: install chromedriver via Homebrew
brew install --cask chromedriver
# Or add a local driver folder to PATH (zsh):
export PATH="$HOME/bin:$PATH"
# Add to ~/.zshrc to persist
echo 'export PATH="$HOME/bin:$PATH"' >> ~/.zshrc
```

Verify Java and Maven:

```bash
java -version
mvn -v
```

---

## 2) Quick setup

1. Clone the repository:

```bash
git clone <repo-url>
cd Selenium_Testing
```

2. Make sure a compatible JDK is installed and JAVA_HOME is set.
3. Install Maven if not present.
4. Ensure Chrome/Firefox is installed and the corresponding driver is available on PATH, or configure the project to download drivers at runtime (WebDriverManager).

Optional: run a quick test to verify environment:

```bash
mvn -q -DskipTests=false test -Dtest=com.auth.tests.gettingStarted.SeleniumTest
```

(Adjust the test path/name to an available sanity test in the project.)

---

## 3) Project layout (short)

Top-level:
- pom.xml — Maven project configuration
- README.md — short project readme
- DOCUMENTATION.md — this file
- resources/ — test resources (example files, screenshots)
- src/main/java/com/auth/pages — Page Object classes
- src/test/java — Test classes organized by feature
- target/ — build/test output

Source vs tests:
- `src/main/java` — production code (page objects, utilities)
- `src/test/java` — test code (TestNG or JUnit tests, BaseTest)
- `resources/` — static files and screenshots used by tests

---

## 4) Test structure & conventions

- Tests are organized by package under `src/test/java` (examples: `alerts`, `dropdown`, `contextMenu`, etc.).
- Naming: Tests typically end with `Test` (e.g., `DropdownTest`, `LoginTest`).
- `BaseTest` (located under `src/test/java/Base/BaseTest.java`) centralizes WebDriver setup/teardown, common helpers, and test lifecycle hooks. New tests should extend `BaseTest` to inherit driver setup.
- Each test class maps to one or more Page Objects from `com.auth.pages`.

Example mapping:
- `test/java/contextMenu/ContextMenuTests.java` -> `com.auth.pages.ContextMenuPage`
- `test/java/dropdown/DropdownTest.java` -> `com.auth.pages.DropDownPage`

When adding tests:
- Create a new test class under an appropriate package.
- Extend `BaseTest` so the driver lifecycle is handled.
- Instantiate page objects via their constructors (pass the driver instance from `BaseTest`).

---

## 5) Page Object Model mapping

The project keeps page objects in `src/main/java/com/auth/pages`. Below are the page classes (one-line inferred descriptions):

- AlertPage — helpers for interacting with JavaScript alerts and confirmations.
- ContextMenuPage — handles right-click/context menu interactions and the resulting alert.
- DropDownPage — selects options and verifies dropdown behavior.
- DynamicLoadingExample1Page — page object for the first dynamic loading example (hidden element reveal).
- DynamicLoadingPage — container page for dynamic loading examples or navigation to them.
- EmailSentPage — represents a success/email sent confirmation page (e.g., after form submission).
- FileUploadPage — helpers to upload files and verify upload success.
- ForgotPasswordPage — interactions for a forgot-password form flow.
- HomePage — landing page helpers and navigation shortcuts.
- HorizontalPage — represents horizontal scroll or slider interactions in a demo.
- HoversPage — interactions for hovering over elements and verifying captions.
- InfiniteScrollPage — helpers to scroll and assert infinite-loading behavior.
- KeyPressesPage — helpers for sending keyboard input and asserting results.
- LargeDeepDomPage — helpers for pages with a large/deep DOM (performance tests or lookups).
- LoginPage — login form interactions (username, password, submit).
- MultipleWindowsPage — helpers to open and switch between multiple windows/tabs.
- SecureAreaPage — page object for post-login secure area (after successful login).
- WysiwygEditorPage — helpers to interact with a rich text (WYSIWYG) editor.

How to add/extend a page object:
1. Create a new Java class in `com.auth.pages`.
2. Add WebElement locators (By) and methods that perform actions and return either void, page objects, or primitives/assertions.
3. Keep constructors that accept `WebDriver driver` and store a reference to reuse in methods.
4. Keep page actions small and focused (one action per method) to improve reusability in tests.

---

## 6) How to run tests

Run full test suite (default):

```bash
mvn test
```

Run a single test class:

```bash
# Use the surefire -Dtest option
mvn -Dtest=DropdownTest test
# Or by package-qualified name if needed
mvn -Dtest=com.auth.tests.dropdown.DropdownTest test
```

Run a single test method:

```bash
mvn -Dtest=LoginTest#testSuccessfulLogin test
```

Headless mode (if the project supports a headless property):

```bash
mvn test -Dselenium.headless=true
```

Parallel execution:
- By default Maven Surefire runs tests sequentially unless a parallel configuration is present in `pom.xml`.
- To enable parallel runs, add/modify the Surefire plugin config in `pom.xml` (example: `parallel=classes`, `threadCount=4`).

Run from IntelliJ IDEA:
- Import the project as a Maven project.
- Open a test class and click the run icon next to the test class or individual test method.
- Ensure the `VM options` or `Environment variables` include any required properties (for example `-Dselenium.headless=true` if desired).

Using `BaseTest` from tests:
- Tests should extend `BaseTest`; the base class typically exposes a `getDriver()` or protected `driver` field to build page objects, e.g.:

```java
LoginPage login = new LoginPage(driver);
```

---

## 7) Screenshots & resources

- `resources/screenshots/` — existing screenshots (e.g., `testSuccessfullLogin.png`). Tests may write screenshots here on failure. Configure paths in `BaseTest` or a logger utility.
- `resources/UplodFile` — sample files used by file upload tests. Reference them with an absolute path or via the classpath when loading resources inside tests.

Example to load a resource in a test:

```java
Path p = Paths.get("resources/UplodFile", "example.png").toAbsolutePath();
fileUploadPage.upload(p.toString());
```

---

## 8) Common troubleshooting

1. Driver mismatch / Session not created:
   - Ensure browser version matches driver version.
   - Use WebDriverManager to avoid manual driver management.
2. Tests fail to find elements (NoSuchElementException):
   - Page timing or dynamic content — add explicit wait (WebDriverWait) in page objects.
   - Ensure selectors (By) still match the application under test.
3. Port or binding errors when starting local services:
   - Confirm no other process uses the same port.
4. Increase Maven logging for troubleshooting:

```bash
mvn -X test
```

5. Test results and reports:
   - Surefire test reports are in `target/surefire-reports/`.
   - Build artifacts are in `target/`.

---

## 9) Next steps & suggested improvements

- Integrate WebDriverManager to automatically download and manage driver binaries.
- Add CI pipeline (GitHub Actions / GitLab CI) to run tests on push/PR with a matrix of browsers.
- Add a test report plugin (Allure or Surefire HTML reports) for better visibility and artifact collection.
- Add a `-Dselenium.headless` Maven profile if not present, and expose browser selection properties (chrome/firefox).
- Add README badges for build status and test report link.

---


