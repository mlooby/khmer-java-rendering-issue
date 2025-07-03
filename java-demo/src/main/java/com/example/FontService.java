package com.example;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.InputStream;

public class FontService
{
    public static Font loadFontFromResources(String resourcePath, float size) throws Exception
    {
        try (InputStream is = FontService.class.getResourceAsStream(resourcePath))
        {
            if (is == null)
            {
                throw new RuntimeException("Font resource not found: " + resourcePath);
            }

            Font font = Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(size);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(font);

            return font;
        }
    }
}
