package com.szachnowicz.simplyshopapp.model;

import com.szachnowicz.simplyshopapp.services.Nouns;

import org.junit.Test;

/**
 * Created by Sebastian on 2018-02-01.
 */
public class NounsTest {


    @Test
    public void testMet() throws Exception {
        String worsd =
                "ball\n" +
                        "bat\n" +
                        "bed\n" +
                        "book\n" +
                        "boy\n" +
                        "bun\n" +
                        "can\n" +
                        "cake\n" +
                        "cap\n" +
                        "car\n" +
                        "cat\n" +
                        "cow\n" +
                        "cub\n" +
                        "cup\n" +
                        "dad\n" +
                        "day\n" +
                        "dog\n" +
                        "doll\n" +
                        "dust\n" +
                        "fan\n" +
                        "feet\n" +
                        "girl\n" +
                        "gun\n" +
                        "hall\n" +
                        "hat\n" +
                        "hen\n" +
                        "jar\n" +
                        "kite\n" +
                        "man\n" +
                        "map\n" +
                        "men\n" +
                        "mom\n" +
                        "pan\n" +
                        "pet\n" +
                        "pie\n" +
                        "pig\n" +
                        "pot\n" +
                        "rat\n" +
                        "son\n" +
                        "sun\n" +
                        "toe\n" +
                        "tub\n" +
                        "van\n" +
                        "apple\n" +
                        "arm\n" +
                        "banana\n" +
                        "bike\n" +
                        "bird\n" +
                        "book\n" +
                        "chin\n" +
                        "clam\n" +
                        "class\n" +
                        "clover\n" +
                        "club\n" +
                        "corn\n" +
                        "crayon\n" +
                        "crow\n" +
                        "crown\n" +
                        "crowd\n" +
                        "crib\n" +
                        "desk\n" +
                        "dime\n" +
                        "dirt\n" +
                        "dress\n" +
                        "fang \n" +
                        "field\n" +
                        "flag\n" +
                        "flower\n" +
                        "fog\n" +
                        "game\n" +
                        "heat\n" +
                        "hill\n" +
                        "home\n" +
                        "horn\n" +
                        "hose\n" +
                        "joke\n" +
                        "juice\n" +
                        "kite\n" +
                        "lake\n" +
                        "maid\n" +
                        "mask\n" +
                        "mice\n" +
                        "milk\n" +
                        "mint\n" +
                        "meal\n" +
                        "meat\n" +
                        "moon\n" +
                        "mother\n" +
                        "morning\n" +
                        "name\n" +
                        "nest\n" +
                        "nose\n" +
                        "pear\n" +
                        "pen\n" +
                        "pencil\n" +
                        "plant\n" +
                        "rain\n" +
                        "river\n" +
                        "road\n" +
                        "rock\n" +
                        "room\n" +
                        "rose\n" +
                        "seed\n" +
                        "shape\n" +
                        "shoe\n" +
                        "shop\n" +
                        "show\n" +
                        "sink\n" +
                        "snail\n" +
                        "snake\n" +
                        "snow\n" +
                        "soda\n" +
                        "sofa\n" +
                        "star\n" +
                        "step\n" +
                        "stew\n" +
                        "stove\n" +
                        "straw\n" +
                        "string\n" +
                        "summer\n" +
                        "swing\n" +
                        "table\n" +
                        "tank\n" +
                        "team\n" +
                        "tent\n" +
                        "test\n" +
                        "toes\n" +
                        "tree\n" +
                        "vest\n" +
                        "water\n" +
                        "wing\n" +
                        "winter\n" +
                        "woman\n" +
                        "women\n" +
                        "alarm\n" +
                        "animal\n" +
                        "aunt\n" +
                        "bait\n" +
                        "balloon\n" +
                        "bath\n" +
                        "bead\n" +
                        "beam\n" +
                        "bean\n" +
                        "bedroom\n" +
                        "boot\n" +
                        "bread\n" +
                        "brick\n" +
                        "brother\n" +
                        "camp\n" +
                        "chicken\n" +
                        "children\n" +
                        "crook\n" +
                        "deer\n" +
                        "dock\n" +
                        "doctor\n" +
                        "downtown\n" +
                        "drum\n" +
                        "dust\n" +
                        "eye\n" +
                        "family\n" +
                        "father\n" +
                        "fight\n" +
                        "flesh\n" +
                        "food\n" +
                        "frog\n" +
                        "goose\n" +
                        "grade\n" +
                        "grandfather\n" +
                        "grandmother\n" +
                        "grape\n" +
                        "grass\n" +
                        "hook\n" +
                        "horse\n" +
                        "jail\n" +
                        "jam\n" +
                        "kiss\n" +
                        "kitten\n" +
                        "light\n" +
                        "loaf\n" +
                        "lock\n" +
                        "lunch\n" +
                        "lunchroom\n" +
                        "meal\n" +
                        "mother\n" +
                        "notebook\n" +
                        "owl\n" +
                        "pail\n" +
                        "parent\n" +
                        "park\n" +
                        "plot\n" +
                        "rabbit\n" +
                        "rake\n" +
                        "robin\n" +
                        "sack\n" +
                        "sail\n" +
                        "scale\n" +
                        "sea\n" +
                        "sister\n" +
                        "soap\n" +
                        "song\n" +
                        "spark\n" +
                        "space\n" +
                        "spoon\n" +
                        "spot\n" +
                        "spy\n" +
                        "summer\n" +
                        "tiger\n" +
                        "toad\n" +
                        "town\n" +
                        "trail\n" +
                        "tramp\n" +
                        "tray\n" +
                        "trick\n" +
                        "trip\n" +
                        "uncle\n" +
                        "vase\n" +
                        "winter\n" +
                        "water\n" +
                        "week\n" +
                        "wheel\n" +
                        "wish\n" +
                        "wool\n" +
                        "yard\n" +
                        "zebra\n" +
                        "actor\n" +
                        "airplane\n" +
                        "airport\n" +
                        "army\n" +
                        "baseball\n" +
                        "beef\n" +
                        "birthday\n" +
                        "boy\n" +
                        "brush\n" +
                        "bushes\n" +
                        "butter \n" +
                        "cast\n" +
                        "cave\n" +
                        "cent\n" +
                        "cherries\n" +
                        "cherry\n" +
                        "cobweb\n" +
                        "coil\n" +
                        "cracker\n" +
                        "dinner\n" +
                        "eggnog\n" +
                        "elbow\n" +
                        "face\n" +
                        "fireman\n" +
                        "flavor\n" +
                        "gate\n" +
                        "glove\n" +
                        "glue\n" +
                        "goldfish\n" +
                        "goose\n" +
                        "grain\n" +
                        "hair\n" +
                        "haircut\n" +
                        "hobbies\n" +
                        "holiday\n" +
                        "hot\n" +
                        "jellyfish\n" +
                        "ladybug\n" +
                        "mailbox\n" +
                        "number\n" +
                        "oatmeal\n" +
                        "pail\n" +
                        "pancake\n" +
                        "pear\n" +
                        "pest\n" +
                        "popcorn\n" +
                        "queen\n" +
                        "quicksand\n" +
                        "quiet\n" +
                        "quilt\n" +
                        "rainstorm\n" +
                        "scarecrow\n" +
                        "scarf\n" +
                        "stream\n" +
                        "street\n" +
                        "sugar\n" +
                        "throne\n" +
                        "toothpaste\n" +
                        "twig\n" +
                        "volleyball\n" +
                        "wood\n" +
                        "wrench\n" +
                        "advice\n" +
                        "anger\n" +
                        "answer\n" +
                        "apple\n" +
                        "arithmetic\n" +
                        "badge\n" +
                        "basket\n" +
                        "basketball\n" +
                        "battle\n" +
                        "beast\n" +
                        "beetle\n" +
                        "beggar\n" +
                        "brain\n" +
                        "branch\n" +
                        "bubble\n" +
                        "bucket\n" +
                        "cactus\n" +
                        "cannon\n" +
                        "cattle\n" +
                        "celery\n" +
                        "cellar\n" +
                        "cloth\n" +
                        "coach\n" +
                        "coast\n" +
                        "crate\n" +
                        "cream\n" +
                        "daughter\n" +
                        "donkey\n" +
                        "drug\n" +
                        "earthquake\n" +
                        "feast\n" +
                        "fifth\n" +
                        "finger\n" +
                        "flock\n" +
                        "frame\n" +
                        "furniture\n" +
                        "geese\n" +
                        "ghost\n" +
                        "giraffe\n" +
                        "governor\n" +
                        "honey\n" +
                        "hope\n" +
                        "hydrant\n" +
                        "icicle\n" +
                        "income\n" +
                        "island\n" +
                        "jeans\n" +
                        "judge\n" +
                        "lace\n" +
                        "lamp\n" +
                        "lettuce\n" +
                        "marble\n" +
                        "month\n" +
                        "north\n" +
                        "ocean\n" +
                        "patch\n" +
                        "plane\n" +
                        "playground\n" +
                        "poison\n" +
                        "riddle\n" +
                        "rifle\n" +
                        "scale\n" +
                        "seashore\n" +
                        "sheet\n" +
                        "sidewalk\n" +
                        "skate\n" +
                        "slave\n" +
                        "sleet\n" +
                        "smoke\n" +
                        "stage\n" +
                        "station\n" +
                        "thrill\n" +
                        "throat\n" +
                        "throne\n" +
                        "title\n" +
                        "toothbrush\n" +
                        "turkey\n" +
                        "underwear\n" +
                        "vacation\n" +
                        "vegetable\n" +
                        "visitor\n" +
                        "voyage\n" +
                        "year\n" +
                        "able\n" +
                        "achieve\n" +
                        "acoustics\n" +
                        "action\n" +
                        "activity\n" +
                        "aftermath\n" +
                        "afternoon\n" +
                        "afterthought\n" +
                        "apparel\n" +
                        "appliance\n" +
                        "beginner\n" +
                        "believe\n" +
                        "bomb\n" +
                        "border\n" +
                        "boundary\n" +
                        "breakfast\n" +
                        "cabbage\n" +
                        "cable\n" +
                        "calculator\n" +
                        "calendar\n" +
                        "caption\n" +
                        "carpenter\n" +
                        "cemetery\n" +
                        "channel\n" +
                        "circle\n" +
                        "creator\n" +
                        "creature\n" +
                        "education\n" +
                        "faucet\n" +
                        "feather\n" +
                        "friction\n" +
                        "fruit\n" +
                        "fuel\n" +
                        "galley\n" +
                        "guide\n" +
                        "guitar\n" +
                        "health\n" +
                        "heart\n" +
                        "idea\n" +
                        "kitten\n" +
                        "laborer\n" +
                        "language\n" +
                        "lawyer\n" +
                        "linen\n" +
                        "locket\n" +
                        "lumber\n" +
                        "magic\n" +
                        "minister\n" +
                        "mitten\n" +
                        "money\n" +
                        "mountain\n" +
                        "music\n" +
                        "partner\n" +
                        "passenger\n" +
                        "pickle\n" +
                        "picture\n" +
                        "plantation\n" +
                        "plastic\n" +
                        "pleasure\n" +
                        "pocket\n" +
                        "police\n" +
                        "pollution\n" +
                        "railway\n" +
                        "recess\n" +
                        "reward\n" +
                        "route\n" +
                        "scene\n" +
                        "scent\n" +
                        "squirrel\n" +
                        "stranger\n" +
                        "suit\n" +
                        "sweater\n" +
                        "temper\n" +
                        "territory\n" +
                        "texture\n" +
                        "thread\n" +
                        "treatment\n" +
                        "veil\n" +
                        "vein\n" +
                        "volcano\n" +
                        "wealth\n" +
                        "weather\n" +
                        "wilderness\n" +
                        "wren\n" +
                        "wrist\n" +
                        "writer\n";

        String[] split = worsd.split("\n");
        System.out.println(split.length);
        String result = "";
        for (String s : split) {
            result += "\""+s +"\""+  ",";

        }
        System.out.println(result);
    }

    @Test
    public void name() throws Exception {

        for (int i = 0; i < 100; i++) {
            System.out.println(Nouns.getRandomNoun());
        }
    }
}