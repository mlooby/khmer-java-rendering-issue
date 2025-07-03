# Khmer Java Rendering Issue

This project demonstrates issues rendering Khmer text using standard Java text layout and JasperReports. It includes working examples using ICU4J and `GlyphVector` to correctly shape and break lines for Khmer, as well as a JasperReports example that uses a custom font extension.

## 📁 Project Structure

<pre> <code>khmer-java-rendering-issue/
├── java-demo/ # Java-only demos showing text rendering issues and icu based rendering
└── jasper-demo/ # JasperReports PDF generation using embedded Khmer fonts</code> </pre>


## 🛠 Requirements

- Java **17**
- Gradle 8+

## ▶️ How to Run

### Clone the repository

```bash
git clone https://github.com/yourusername/khmer-java-rendering-issue.git
cd khmer-java-rendering-issue
```
Run the broken Java text layout demo.
This runs KhmerTest.java, which uses standard Java text APIs and shows broken Khmer rendering:

```bash
./gradlew :java-demo:run
```
Run the ICU4J + GlyphVector demo (correct rendering)
This runs KhmerTestGlyphVector.java, using ICU4J's BreakIterator and GlyphVector for correct shaping and line-breaking:
```bash
./gradlew :java-demo:runGlyphVectorDemo
```
Run the JasperReports PDF generation
This compiles and runs GenerateReport.java, filling a .jrxml template and producing a PDF using a font extension:
```bash
./gradlew :jasper-demo:run
```
The output PDF will be saved as:

jasper-demo/build/output/khmer_test_output.pdf

🔤 Font Extension Details

The custom font extension JAR NotoSansKhmer.jar includes:

NotoSansKhmer-Regular.ttf\
NotoSansKhmer-Bold.ttf

✅ Status

- Java demo using default layout (broken)
- Java demo using ICU4J (correct)
- JasperReports PDF generation with embedded Khmer font (broken)

Feel free to open an issue or pull request with fixes, improvements, or questions.
