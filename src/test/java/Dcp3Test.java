import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import problems.Dcp3;

class Dcp3Test {

    Dcp3 dcp;

    @BeforeEach
    void setup() {
        dcp = new Dcp3();
    }

    @Nested
    class Serialize {

        @Test
        void serializeNodeTest() {
            //Given
            Dcp3.Node node = new Dcp3.Node("root", new Dcp3.Node("left",
                    new Dcp3.Node("left.left")), new Dcp3.Node("right"));

            //When
            String serialized = dcp.serialize(node);

            //Then
            String expected = "root,left,left.left,#,#,#,right,#,#";

            Assertions.assertThat(serialized).isEqualTo(expected);
        }

 /*
                node2 =
                       a
                    /    \
                   /      \
                  b        c
                 / \      / \
                d   e    f   g
               / \      /
              h   i    j
             /
            k
*/

        @Test
        void serializeNode2Test() {
            //Given
            Dcp3.Node node2 = new Dcp3.Node("a", new Dcp3.Node("b",
                    new Dcp3.Node("d", new Dcp3.Node("h", new Dcp3.Node("k")),
                            new Dcp3.Node("i")), new Dcp3.Node("e")), new Dcp3.Node("c",
                    new Dcp3.Node("f", new Dcp3.Node("j")), new Dcp3.Node("g")));

            //When
            String serialized = dcp.serialize(node2);

            //Then
            String expected = "a,b,d,h,k,#,#,#,i,#,#,e,#,#,c,f,j,#,#,#,g,#,#";
            Assertions.assertThat(serialized).isEqualTo(expected);
        }

        /*
                   node3 =
                        a
                      /   \
                     b      c
                      \
                       d
                      / \
                     e   f
                          \
                           g
    */
        @Test
        void serializeNode3Test() {
            //Given
            Dcp3.Node node3 = new Dcp3.Node("a", new Dcp3.Node("b", null, new Dcp3.Node("d",
                    new Dcp3.Node("e"), new Dcp3.Node("f", null, new Dcp3.Node("g")))),
                    new Dcp3.Node("c"));

            //When
            String serialized = dcp.serialize(node3);

            //Then
            String expected = "a,b,#,d,e,#,#,f,#,g,#,#,c,#,#";
            Assertions.assertThat(serialized).isEqualTo(expected);
        }
    }

    @Nested
    class Deserialize {

        @Test
        void deserializeNodeTest() {
            //Given
            String serialized = "root,left,left.left,#,#,#,right,#,#";

            //When
            Dcp3.Node deserialized = dcp.deserialize(serialized);

            //Then
            Dcp3.Node expected = new Dcp3.Node("root", new Dcp3.Node("left",
                    new Dcp3.Node("left.left")), new Dcp3.Node("right"));

            Assertions.assertThat(deserialized).isEqualTo(expected);
        }

        @Test
        void deserializeNode2Test() {
            //Given
            String serializedNode = "a,b,d,h,k,#,#,#,i,#,#,e,#,#,c,f,j,#,#,#,g,#,#";

            //When
            Dcp3.Node deserialized = dcp.deserialize(serializedNode);

            //Then
            Dcp3.Node expected = new Dcp3.Node("a", new Dcp3.Node("b",
                    new Dcp3.Node("d", new Dcp3.Node("h", new Dcp3.Node("k")),
                            new Dcp3.Node("i")), new Dcp3.Node("e")), new Dcp3.Node("c",
                    new Dcp3.Node("f", new Dcp3.Node("j")), new Dcp3.Node("g")));

            Assertions.assertThat(deserialized).isEqualTo(expected);
        }

        @Test
        void deserializeNode3Test() {
            //Given
            String serialized = "a,b,#,d,e,#,#,f,#,g,#,#,c,#,#";

            //When
            Dcp3.Node deserialized = dcp.deserialize(serialized);

            //Then
            Dcp3.Node expected = new Dcp3.Node("a", new Dcp3.Node("b", null, new Dcp3.Node("d",
                    new Dcp3.Node("e"), new Dcp3.Node("f", null, new Dcp3.Node("g")))),
                    new Dcp3.Node("c"));

            Assertions.assertThat(deserialized).isEqualTo(expected);
        }
    }

    @Nested
    class SerializeAndDeserialize {
        @Test
        void serializeAndDeserializeNode() {
            //Given
            Dcp3.Node node = new Dcp3.Node("root", new Dcp3.Node("left",
                    new Dcp3.Node("left.left")), new Dcp3.Node("right"));

            //When
            String serialized = dcp.serialize(node);
            Dcp3.Node deserialized = dcp.deserialize(serialized);

            //Then
            Assertions.assertThat(deserialized).isEqualTo(node);
        }

        @Test
        void serializeAndDeserializeNode2() {
            //Given
            Dcp3.Node node2 = new Dcp3.Node("a", new Dcp3.Node("b",
                    new Dcp3.Node("d", new Dcp3.Node("h", new Dcp3.Node("k")),
                            new Dcp3.Node("i")), new Dcp3.Node("e")), new Dcp3.Node("c",
                    new Dcp3.Node("f", new Dcp3.Node("j")), new Dcp3.Node("g")));

            //When
            String serialized = dcp.serialize(node2);
            Dcp3.Node deserialized = dcp.deserialize(serialized);

            //Then
            Assertions.assertThat(deserialized).isEqualTo(node2);
        }

        @Test
        void serializeAndDeserializeNode3() {
            //Given
            Dcp3.Node node3 = new Dcp3.Node("a", new Dcp3.Node("b", null, new Dcp3.Node("d",
                    new Dcp3.Node("e"), new Dcp3.Node("f", null, new Dcp3.Node("g")))),
                    new Dcp3.Node("c"));

            //When
            String serialized = dcp.serialize(node3);
            Dcp3.Node deserialized = dcp.deserialize(serialized);

            //Then
            Assertions.assertThat(node3).isEqualTo(deserialized);

        }
    }
}