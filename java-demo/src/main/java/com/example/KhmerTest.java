package com.example;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextAttribute;
import java.awt.font.TextLayout;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;

public class KhmerTest {

    public static void main(String[] args) throws Exception
    {
        int width = args.length > 0 ? Integer.parseInt(args[0]) : 800;

        String khmer = "ក្នុងឋានៈជាសមាជិកនៃសង្គម មនុស្សគ្រប់រូប មានសិទ្ធិទទួលបានសន្តិសុខសង្គម និងមានបុព្វសិទ្ធិសម្រេចបានសិទ្ធិខាងសេដ្ឋកិច្ច សង្គមកិច្ច និងវប្បធម៌ ដែលចាំបាច់សម្រាប់សេចក្ដីថ្លៃថ្នូរ និងការរីកចំរើនដោយសេរីនៃបុគ្គលិកលក្ខណៈរបស់ខ្លួន តាមរយៈការខិតខំរបស់ជាតិ និងការរៀបចំ និងធនធានរបស់ប្រទេសនីមួយៗ។ មនុស្សគ្រប់រូប មានសិទ្ធិឈប់សម្រាក និងលំហែកំសាន្ត រួមបញ្ចូលទាំងកម្រិតម៉ោងការងារ សមហេតុផល និងការឈប់សម្រាក ដោយបានប្រាក់បៀវត្សតាមពេលកំណត់ទៀងទាត់។ មនុស្សគ្រប់រូប មានសិទ្ធិទទួលបាននូវសណ្ដាប់ធ្នាប់សង្គមនិងអន្ដរជាតិ ដែលធ្វើឱ្យសិទ្ធិ និងសេរីភាព ចែងក្នុងសេចក្ដីប្រកាសនេះ អាចសម្រេចបានដោយពេញលេញ។ គ្មានបទបញ្ញត្ដិណាមួយនៃសេចក្ដីប្រកាសនេះ អាចត្រូវបានបកស្រាយ តម្រូវថា រដ្ឋណាមួយ ក្រុមណាមួយ ឬបុគ្គលណាម្នាក់ មានសិទ្ធិបែបណាមួយ ក្នុងការធ្វើសកម្មភាព ឬការប្រព្រឹត្ដអំពើអ្វីមួយ ដែលសំដៅទៅបំផ្លិចបំផ្លាញនូវសិទ្ធិ និងសេរីភាពទាំងឡាយ ដែលមានចែងនៅក្នុងសេចក្ដីប្រកាសនេះឡើយ។";

        // Load and register the font
        Font khmerFont = FontService.loadFontFromResources("/fonts/NotoSansKhmer-Regular.ttf", 12f);
       // GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(khmerFont);

        // Apply font to attributed string
        AttributedString attrStr = new AttributedString(khmer);
        //attrStr.addAttribute(TextAttribute.FONT, khmerFont);

        AttributedCharacterIterator it = attrStr.getIterator();

        // Default Java LineBreakMeasurer (not Khmer aware)
        LineBreakMeasurer measurer = new LineBreakMeasurer(it, new FontRenderContext(null, true, true));

        while (measurer.getPosition() < it.getEndIndex())
       	{
            TextLayout layout = measurer.nextLayout(width);
            int start = measurer.getPosition() - layout.getCharacterCount();
            System.out.println("Segment: " + khmer.substring(start, start + layout.getCharacterCount()));
        }
    }
}
