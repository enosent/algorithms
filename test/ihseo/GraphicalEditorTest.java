package ihseo;

import programming.GraphicalEditor;

import java.util.ArrayList;
import java.util.List;

public class GraphicalEditorTest {

    public static void main(String[] args) {
        GraphicalEditor graphic = new GraphicalEditor();

        String[] input = {
            "I 5 6", "g 5 6", "L 2 3 A", "V 3 3 5 W", "H 1 4 4 H", "S one.bmp",
            "F 3 3 J","K 2 2 4 4 Y", "S two.bmp"};

        for(int i = 0; i < input.length; i++)
            graphic.createBitMappedImages(input[i].split(" "));

    }
}
