package com.example;

import com.ibm.icu.text.BreakIterator;

import java.util.Locale;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.util.ArrayList;
import java.util.List;

public class KhmerTestGlyphVector
{
    public static void main(String[] args) throws Exception
    {
        String khmer = "ត្ក្នុងឋានៈជាសមាជិកនៃសង្គម មនុស្សគ្រប់រូបមានសិទ្ធិទទួលបានសន្ដិសុខសង្គម និងមានបុព្វសិទ្ធិសម្រេចបានសិទ្ធិខាងសេដ្ឋកិច្ច សង្គមកិច្ច និងវប្បធម៌ ដែលចាំបាច់សម្រាប់សេចក្ដីថ្លៃថ្នូរ និងការរីកចំរើនដោយសេរីនៃបុគ្គលិកលក្ខណៈរបស់ខ្លួន តាមរយៈការខិតខំរបស់ជាតិ និងសហប្រតិបត្ដិការអន្ដរជាតិ និងដោយយោងទៅតាមការរៀបចំ និងធនធានរបស់ប្រទេសនីមួយៗ។ មនុស្សគ្រប់រូបមានសិទ្ធិឈប់សម្រាក និងលំហែកំសាន្ដ រួមបញ្ចូលទាំងកម្រិតម៉ោងការងារសមហេតុផល និងការឈប់សម្រាកដោយបានប្រាក់បៀវត្សតាមពេលកំណត់ទៀងទាត់។ មនុស្សគ្រប់រូបមានសិទ្ធិទទួលបាននូវសណ្ដាប់ធ្នាប់សង្គមនិងអន្ដរជាតិ ដែលធ្វើឱ្យសិទ្ធិ និងសេរីភាពចែងក្នុងសេចក្ដីប្រកាសនេះ អាចសម្រេចបានដោយពេញលេញ។ គ្មានបទបញ្ញត្ដិណាមួយនៃសេចក្ដីប្រកាសនេះ អាចត្រូវបានបកស្រាយតម្រូវថា រដ្ឋណាមួយ ក្រុមណាមួយ ឬបុគ្គលណាម្នាក់ មានសិទ្ធិបែបណាមួយក្នុងការធ្វើសកម្មភាព ឬការប្រព្រឹត្ដអំពើអ្វីមួយដែលសំដៅទៅបំផ្លិចបំផ្លាញនូវសិទ្ធិ និងសេរីភាពទាំងឡាយដែលមានចែងនៅក្នុងសេចក្ដីប្រកាសនេះឡើយ។";

        // Load and register font
        Font notoSansKhmer = FontService.loadFontFromResources("/fonts/NotoSansKhmer-Regular.ttf", 12f);
        GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(notoSansKhmer);

        // Set up rendering context
        FontRenderContext frc = new FontRenderContext(null, true, true);

        // Line width in pixels
        float maxWidth = 800f;

        // Line breaking logic
        List<String> lines = breakTextIntoLines(khmer, notoSansKhmer, frc, maxWidth);

        // Print line segments
        for (String line : lines)
        {
            System.out.println("Line: " + line);
        }
    }

    static List<String> breakTextIntoLines(String text, Font font, FontRenderContext frc, float maxWidth)
    {
        List<String> lines = new ArrayList<>();
        BreakIterator breaker = BreakIterator.getLineInstance(new Locale("km"));
        breaker.setText(text);

        int start = breaker.first();
        int end = breaker.next();
        int lineStart = start;
        float lineWidth = 0f;

        while (end != BreakIterator.DONE)
        {
            String candidate = text.substring(lineStart, end);
            GlyphVector gv = font.createGlyphVector(frc, candidate);
            float width = (float) gv.getLogicalBounds().getWidth();

            if (lineWidth + width > maxWidth && lineWidth > 0)
            {
                lines.add(text.substring(start, lineStart));
                start = lineStart;
                lineWidth = 0f;
            }

            lineWidth += width;
            lineStart = end;
            end = breaker.next();
        }

        if (start < text.length())
        {
            lines.add(text.substring(start));
        }

        return lines;
    }

}

