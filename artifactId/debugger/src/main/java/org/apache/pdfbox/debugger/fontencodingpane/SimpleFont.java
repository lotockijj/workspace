/*
 * Copyright 2015 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.pdfbox.debugger.fontencodingpane;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.JPanel;
import org.apache.pdfbox.pdmodel.font.PDSimpleFont;

/**
 * @author Khyrul Bashar
 * A class that shows the glyph table along with unicode characters for SimpleFont.
 */
class SimpleFont implements FontPane
{
    public static final String NO_GLYPH = "No glyph";
    private int totalAvailableGlyph = 0;
    private final FontEncodingView view;

    /**
     * Constructor.
     * @param font PDSimpleFont instance.
     * @throws IOException If fails to parse unicode characters.
     */
    SimpleFont(PDSimpleFont font) throws IOException
    {
        Object[][] tableData = getGlyphs(font);

        Map<String, String> attributes = new LinkedHashMap<String, String>();
        attributes.put("Encoding", getEncodingName(font));
        attributes.put("Font", font.getName());
        attributes.put("Glyph count", Integer.toString(totalAvailableGlyph));

        view = new FontEncodingView(tableData, attributes, new String[] {"Code", "Glyph Name","Unicode Character"});
    }

    private Object[][] getGlyphs(PDSimpleFont font) throws IOException
    {
        Object[][] glyphs = new Object[256][3];

        for (int index = 0; index <= 255; index++)
        {
            glyphs[index][0] = index;
            if (font.getEncoding().contains(index))
            {
                glyphs[index][1] = font.getEncoding().getName(index);
                glyphs[index][2] = font.toUnicode(index);
                totalAvailableGlyph++;
            }
            else
            {
                glyphs[index][1] = NO_GLYPH;
                glyphs[index][2] = NO_GLYPH;
            }
        }
        return glyphs;
    }


    private String getEncodingName(PDSimpleFont font)
    {
        return font.getEncoding().getClass().getSimpleName();
    }

    @Override
    public JPanel getPanel()
    {
        return view.getPanel();
    }
}
