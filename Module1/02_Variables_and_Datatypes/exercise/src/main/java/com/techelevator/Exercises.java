package com.techelevator;

public class Exercises {

	public static void main(String[] args) {
		int joins = 0;
        /* Exercise 1
        1. 4 birds are sitting on a branch. 1 flies away. How many birds are left on
        the branch?
        */
		// ### EXAMPLE:
		int birdsOnABranch = 4;
		int birdsThatFlyAway = 1;
		int birdsRemaining = birdsOnABranch - birdsThatFlyAway;

        /* Exercise 2
        2. There are 6 birds and 3 nests. How many more birds are there than
        nests?
        */
		// ### EXAMPLE:
		int numberOfBirds = 6;
		int numberOfNests = 3;
		int numberOfExtraBirds = numberOfBirds - numberOfNests;

        /* Exercise 3
        3. 3 raccoons are playing in the woods. 2 go home to eat dinner. How
        many raccoons are left in the woods?
        */
		int racoons_Playing = 3;
		int racoons_Go_Home = 2;
		int left = racoons_Playing - racoons_Go_Home;

        /* Exercise 4
        4. There are 5 flowers and 3 bees. How many less bees than flowers?
        */
		int flowers = 5;
		int bees = 3;
		int bees_To_Flowers = flowers - bees;


        /* Exercise 5
        5. 1 lonely pigeon was eating breadcrumbs. Another pigeon came to eat
        breadcrumbs, too. How many pigeons are eating breadcrumbs now?
        */
		int pigeons_Eating_Breadcrumbs = 1;
		int pigeons_Joins = 1;
		int sum_Of_Pigeons = pigeons_Eating_Breadcrumbs + pigeons_Joins;


        /* Exercise 6
        6. 3 owls were sitting on the fence. 2 more owls joined them. How many
        owls are on the fence now?
        */
		int owls_Sitting = 3;
		int owl_Joins = 2;
		int owls_On_The_Fence = owls_Sitting + owl_Joins;


        /* Exercise 7
        7. 2 beavers were working on their home. 1 went for a swim. How many
        beavers are still working on their home?
        */

		int beavers_Working = 2;
		int beavers_Swimming = 1;
		int sum_Of_Beavers_Working = beavers_Working - beavers_Swimming;


        /* Exercise 8
        8. 2 toucans are sitting on a tree limb. 1 more toucan joins them. How
        many toucans in all?
        */
		int toucans_Sitting_on_a_tree = 2;
		int toucans_Joins = 1;
		int sum_Of_Toucans_Sitting_On_A_Tree = toucans_Sitting_on_a_tree + toucans_Joins;




        /* Exercise 9
        9. There are 4 squirrels in a tree with 2 nuts. How many more squirrels
        are there than nuts?
        */
		int squirrels_In_A_Tree = 4;
		int nuts = 2;
		int total_Nuts = squirrels_In_A_Tree - nuts;


        /* Exercise 10
        10. Mrs. Hilt found a quarter, 1 dime, and 2 nickels. How much money did
        she find?
        */
		double quarter = 0.25;
		double dime = 0.10;
		double nickel = 0.05;
		double found_Money = quarter + dime + (2 * nickel);


        /* Exercise 11
        11. Mrs. Hilt's favorite first grade classes are baking muffins. Mrs. Brier's
        class bakes 18 muffins, Mrs. MacAdams's class bakes 20 muffins, and
        Mrs. Flannery's class bakes 17 muffins. How many muffins does first
        grade bake in all?
        */
		int mrs_Briers_Class_Muffins = 18;
		int mrs_MacAdams_Class_Muffins = 20;
		int mrs_Flannery_Class_Muffins = 17;

		int first_Grade_Class_Bakes = mrs_Briers_Class_Muffins + mrs_Flannery_Class_Muffins + mrs_MacAdams_Class_Muffins;


        /* Exercise 12
        12. Mrs. Hilt bought a yoyo for 24 cents and a whistle for 14 cents. How
        much did she spend in all for the two toys?
        */
		double yoyo = 0.24;
		double whistle = 0.14;
		double mrs_Hilt_Sum = yoyo + whistle;


        /* Exercise 13
        13. Mrs. Hilt made 5 Rice Krispies Treats. She used 8 large marshmallows
        and 10 mini marshmallows.How many marshmallows did she use
        altogether?
        */
		int rice_Krispies = 5;
		int large_Marshmallows = 8;
		int mini_Marshmallows = 10;
		int sum_Of_Marshmallows = large_Marshmallows + mini_Marshmallows;



        /* Exercise 14
        14. At Mrs. Hilt's house, there was 29 inches of snow, and Brecknock
        Elementary School received 17 inches of snow. How much more snow
        did Mrs. Hilt's house have?
        */
		int snow_At_Hilts_House = 29;
		int snow_At_Brecknock_Elementary_School = 17;
		int sum_Of_Snow = snow_At_Hilts_House - snow_At_Brecknock_Elementary_School;

        /* Exercise 15
        15. Mrs. Hilt has $10. She spends $3 on a toy truck and $2.50 on a pencil
        case. How much money does she have left?
        */
		int mrs_hilt_Money = 10;
		int toy_Truck = 3;
		double pencil = 2.50;
		double remainder_Of_Money = mrs_hilt_Money - toy_Truck - pencil;



        /* Exercise 16
        16. Josh had 16 marbles in his collection. He lost 7 marbles. How many
        marbles does he have now?
        */
		int joshs_Marbles = 16;
		int lost_Marbles = 7;
		int sum_Of_Marbles = joshs_Marbles - lost_Marbles;

        /* Exercise 17
        17. Megan has 19 seashells. How many more seashells does she need to
        find to have 25 seashells in her collection?
        */
		int megans_Seashells = 19;
		int seashells_Goal = 25;
		int leftover_Until_Seashells_Goal = seashells_Goal - megans_Seashells;


        /* Exercise 18
        18. Brad has 17 balloons. 8 balloons are red and the rest are green. How
        many green balloons does Brad have?
        */

		int brads_balloons = 17;
		int red_Balloons = 8;
		int green_Balloons = brads_balloons - red_Balloons;


        /* Exercise 19
        19. There are 38 books on the shelf. Marta put 10 more books on the shelf.
        How many books are on the shelf now?
        */

		int books_On_Shelf = 38;
		int martha_Places_Books = 10;
		int sum_Of_Books_On_Shelf = books_On_Shelf + martha_Places_Books;



        /* Exercise 20
        20. A bee has 6 legs. How many legs do 8 bees have?
        */
		int bee_Legs = 6;
		int num_Of_Bees = 8;
		int sum_Of_Legs = bee_Legs * num_Of_Bees;


        /* Exercise 21
        21. Mrs. Hilt bought an ice cream cone for 99 cents. How much would 2 ice
        cream cones cost?
        */
		double ice_Cream_Cone = 0.99;
		int num_Ice_Cream_Cone = 2;
		double amount_For_Ice_Cream = ice_Cream_Cone * num_Ice_Cream_Cone;

        /* Exercise 22
        22. Mrs. Hilt wants to make a border around her garden. She needs 125
        rocks to complete the border. She has 64 rocks. How many more rocks
        does she need to complete the border?
        */
		int has_Rocks = 64;
		int goal_Num_Rocks = 125;
		int rocks_Needed = goal_Num_Rocks - has_Rocks;


        /* Exercise 23
        23. Mrs. Hilt had 38 marbles. She lost 15 of them. How many marbles does
        she have left?
        */
		int hilts_Marbles = 38;
		int hilts_Lost_Marbles = 15;
		int sum_Of_Hilts_Marbles = hilts_Marbles - hilts_Lost_Marbles;


        /* Exercise 24
        24. Mrs. Hilt and her sister drove to a concert 78 miles away. They drove 32
        miles and then stopped for gas. How many miles did they have left to drive?
        */

		int hilts_Drive_To_Concert = 78;
		int stopped_For_Gas_At = 32;
		int leftover_Miles = hilts_Drive_To_Concert - stopped_For_Gas_At;


        /* Exercise 25
        25. Mrs. Hilt spent 1 hour and 30 minutes shoveling snow on Saturday
        morning and 45 minutes shoveling snow on Saturday afternoon. How
        much total time (in minutes) did she spend shoveling snow?
        */
		int time_Shoveling_Snow = 90;
		int additional_Time_Shoveling_Snow = 45;
		int sum_Of_Time_Shoveling_Snow = time_Shoveling_Snow + additional_Time_Shoveling_Snow;


        /* Exercise 26
        26. Mrs. Hilt bought 6 hot dogs. Each hot dog cost 50 cents. How much
        money did she pay for all of the hot dogs?
        */
		int hilts_Hot_dogs = 6;
		double cost_Of_Hot_Dog = .50;
		double total_Cost_For_Hot_Dogs = hilts_Hot_dogs * cost_Of_Hot_Dog;


        /* Exercise 27
        27. Mrs. Hilt has 50 cents. A pencil costs 7 cents. How many pencils can
        she buy with the money she has?
        */
		int hilts_cents = 50;
		int hilts_Pencil_Cost = 07;
		int can_Buy_Pencils = hilts_cents / hilts_Pencil_Cost;



        /* Exercise 28
        28. Mrs. Hilt saw 33 butterflies. Some of the butterflies were red and others
        were orange. If 20 of the butterflies were orange, how many of them
        were red?
        */
		int hilts_Seen_Butterflies = 33;
		int orange_Butterflies = 20;
		int red_Butterflies = hilts_Seen_Butterflies - orange_Butterflies;


        /* Exercise 29
        29. Kate gave the clerk $1.00. Her candy cost 54 cents. How much change
        should Kate get back?
        */
		double kate_gave = 1;
		double candy_Cost = .54;
		double kates_Change = kate_gave - candy_Cost;



        /* Exercise 30
        30. Mark has 13 trees in his backyard. If he plants 12 more, how many trees
        will he have?
        */
		int num_Of_Trees = 13;
		int plant_Trees = 12;
		int sum_Trees = num_Of_Trees + plant_Trees;


        /* Exercise 31
        31. Joy will see her grandma in two days. How many hours until she sees
        her?
        */
		int days_Seeing_Grandma = 2;
		int num_Hours_In_A_Day = 24;
		int total_Hours_With_Grandma = days_Seeing_Grandma * num_Hours_In_A_Day;


        /* Exercise 32
        32. Kim has 4 cousins. She wants to give each one 5 pieces of gum. How
        much gum will she need?
        */
		int kim_Cousins = 4;
		int pieces_Of_Gum = 5;
		int kim_Gives_Amount_Of_Gum = kim_Cousins * pieces_Of_Gum;


        /* Exercise 33
        33. Dan has $3.00. He bought a candy bar for $1.00. How much money is
        left?
        */
		double dans_Money = 3;
		double purchased_Candy_For = 1;
		double dans_Leftover = dans_Money - purchased_Candy_For;


        /* Exercise 34
        34. 5 boats are in the lake. Each boat has 3 people. How many people are
        on boats in the lake?
        */
		int boats_In_The_Lake = 5;
		int people_Per_Boat = 3;
		int sum_Of_People_In_Boats =  boats_In_The_Lake * people_Per_Boat;



        /* Exercise 35
        35. Ellen had 380 legos, but she lost 57 of them. How many legos does she
        have now?
        */
		int ellen_Legos = 380;
		int lost_Legos = 57;
		int legos_Leftover = ellen_Legos - lost_Legos;


        /* Exercise 36
        36. Arthur baked 35 muffins. How many more muffins does Arthur have to
        bake to have 83 muffins?
        */
		int arthur_Baked_Muffines = 35;
		int baking_Muffin_Goal = 83;
		int left_To_Bake = baking_Muffin_Goal - arthur_Baked_Muffines;

        /* Exercise 37
        37. Willy has 1400 crayons. Lucy has 290 crayons. How many more
        crayons does Willy have then Lucy?
        */

		int willys_Num_Crayons = 1400;
		int lucys_Num_Crayons = 290;
		int willy_Has_More_Crayons_By = willys_Num_Crayons - lucys_Num_Crayons;


        /* Exercise 38
        38. There are 10 stickers on a page. If you have 22 pages of stickers, how
        many stickers do you have?
        */
		int stickers_Per_Page = 10;
		int num_Of_Pages = 22;
		int sum_Total_Of_Stickers = stickers_Per_Page * num_Of_Pages;


        /* Exercise 39
        39. There are 100 cupcakes for 8 children to share. How much will each
        person get if they share the cupcakes equally?
        */
		double cupcakes = 100;
		int children = 8;
		double cupcakes_Per_Child = cupcakes / children;


        /* Exercise 40
        40. She made 47 gingerbread cookies which she will distribute equally in
        tiny glass jars. If each jar is to contain six cookies, how many
        cookies will not be placed in a jar?
        */
		int num_Gingerbread_Cookies = 47;
		int each_Jar_Contains_Num_Cookies = 6;
		int leftover_Cookies = num_Gingerbread_Cookies % each_Jar_Contains_Num_Cookies;


        /* Exercise 41
        41. She also prepared 59 croissants which she plans to give to her 8
        neighbors. If each neighbor received an equal number of croissants,
        how many will be left with Marian?
        */
		int prepared_Croissants = 59;
		int num_Neighbors = 8;
		int leftover_Croissants = prepared_Croissants % num_Neighbors;


        /* Exercise 42
        42. Marian also baked oatmeal cookies for her classmates. If she can
        place 12 cookies on a tray at a time, how many trays will she need to
        prepare 276 oatmeal cookies at a time?
        */

		int cookies_Per_Tray = 12;
		int cookie_Goal = 276;
		int cookie_Division = cookie_Goal / cookies_Per_Tray;


        /* Exercise 43
        43. Marian’s friends were coming over that afternoon so she made 480
        bite-sized pretzels. If one serving is equal to 12 pretzels, how many
        servings of bite-sized pretzels was Marian able to prepare?
        */
		int bite_Sized_Pretzels = 480;
		int whole_Pretzels = 12;
		int bite_To_Whole_Pretzels = bite_Sized_Pretzels / whole_Pretzels;


        /* Exercise 44
        44. Lastly, she baked 53 lemon cupcakes for the children living in the city
        orphanage. If two lemon cupcakes were left at home, how many
        boxes with 3 lemon cupcakes each were given away?
        */

		int baked_Lemon_Cupcakes = 53;
		int cupcakes_Left = 2;
		int new_Sum_Cupcakes = baked_Lemon_Cupcakes - cupcakes_Left;
		int per_Box = 3;
		int boxes_Of_Cupcakes =  new_Sum_Cupcakes / per_Box;


        /* Exercise 45
        45. Susie's mom prepared 74 carrot sticks for breakfast. If the carrots
        were served equally to 12 people, how many carrot sticks were left
        uneaten?
        */
		int carrot_Sticks = 74;
		int served_To_People = 12;
		double leftover_Carrots = carrot_Sticks / served_To_People;


        /* Exercise 46
        46. Susie and her sister gathered all 98 of their teddy bears and placed
        them on the shelves in their bedroom. If every shelf can carry a
        maximum of 7 teddy bears, how many shelves will be filled?
        */
		int teddy_Bears = 98;
		int max_Per_Shelf = 7;
		int filled_Shelves = teddy_Bears / max_Per_Shelf;


        /* Exercise 47
        47. Susie’s mother collected all family pictures and wanted to place all of
        them in an album. If an album can contain 20 pictures, how many
        albums will she need if there are 480 pictures?
        */
		int album_Contains = 20;
		int album_Goal = 480;
		int album_Division = album_Goal / album_Contains;


        /* Exercise 48
        48. Joe, Susie’s brother, collected all 94 trading cards scattered in his
        room and placed them in boxes. If a full box can hold a maximum of 8
        cards, how many boxes were filled and how many cards are there in
        the unfilled box?
        */
		int max_Full_Box_Of_Cards = 8;
		int cards_Collected = 94;
		int boxes_Filled = cards_Collected / max_Full_Box_Of_Cards;
		int cards_Remaining = cards_Collected % max_Full_Box_Of_Cards;


        /* Exercise 49
        49. Susie’s father repaired the bookshelves in the reading room. If he has
        210 books to be distributed equally on the 10 shelves he repaired,
        how many books will each shelf contain?
        */

		int num_Books = 210;
		int total_Shelf = 10;
		int shelf_Contains = num_Books / total_Shelf;




        /* Exercise 50
        50. Cristina baked 17 croissants. If she planned to serve this equally to
        her seven guests, how many will each have?
        */
		double baked_Croissants = 17;
		double total_Guests = 7;
		double divided_Croissants_Per_Person = baked_Croissants / total_Guests;



	    /* Exercise 51
	    51. Bill and Jill are house painters. Bill can paint a standard room in 2.15 hours, while Jill averages
	    1.90 hours. How long will it take the two painters working together to paint 5 standard rooms?
	    Hint: Calculate the rate at which each painter can complete a room (rooms / hour), combine those rates, 
	    and then divide the total number of rooms to be painted by the combined rate.
	    */
		double bill_Rate = 2.15;
		double jills_Rate = 1.90;
		double combine_Rate = bill_Rate + jills_Rate;
		int num_Rooms = 5;
		double sum_Time_Rooms = combine_Rate / num_Gingerbread_Cookies;

     

	    /* Exercise 52
	    52. Create and assign variables to hold a first name, last name, and middle initial. Using concatenation,
		build an additional variable to hold the full name in the order of last name, first name, middle initial. The
		last and first names should be separated by a comma followed by a space, and the middle initial must end
		with a period. Use "Grace", "Hopper, and "B" for the first name, last name, and middle initial.
		Example: "John", "Smith, "D" —> "Smith, John D."
	    */

		String first_Name = "Grace";
		String last_Name = "Hopper";
		String middle_Initial = "B";

		String full_Name = last_Name + ", " + first_Name + middle_Initial + ".";


	    /* Exercise 53
	    53. The distance between New York and Chicago is 800 miles, and the train has already travelled 537 miles.
	    What percentage of the trip as a whole number has been completed?
	    */
		int ny_To_Chicago = 800;
		int traveled = 537;



	}

}
