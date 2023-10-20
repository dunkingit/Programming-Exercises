package com.techelevator;
public class Text {
   static final String[] ENTER_FILE_CHOICES = {"Enter file name", "Use our default file", "Return to the previous menu"};
   static final String THANKS = "🛍️ THANK YOU for shopping with us! 😊🎉 Come back soon!";
   static final String VALID = "\n🤷 Oops! Please select a valid option and try again. 🔄\n";
   static final String FUNNY = "😂 THANK YOU for trusting me with $1000 of your cash! \n" +
           "Even my cat is more responsible with money. 🐱\nGood luck getting a refund. Remember, " +
           "you chose to put $1000 in a vending machine! 🎰 GOOD LUCK! 🍀";
   static final String ENTER_NUMBER_FOR_QUANTITY = "🤔 Please enter the NUMBER of candies you wish to bankrupt us with:";
   static final String NOT_ENOUGH_PRODUCT_ERROR = "🙇‍♂️ We're super sorry but your request is just TOO AWESOME for our inventory. \nTry asking for fewer so others don't get jealous.";
   static final String ENTERED_ZERO_ERROR_MESSAGE = "🧐 Hmm... 0 items, really? Try again and pick a real number!";
   static final String ASK_FOR_ID = "🍫 Craving something specific? Enter the item Id or 'x' to bail:";
   static final String ERROR_ID_NOT_FOUND = "🕵️‍♂️ Oops! That item is like a unicorn. We can't find it! Try again.";
   static final String SOLD_OUT_ERROR = "🙅‍♂️ GONE! Like hotcakes. Sorry, that item is sold out. 😢";
   static final String HEADER = String.format("%-10s  %-15s  %-5s  %-5s  %-5s",
           "🆔 Id", "🍬 Name", "🎁 Wrapper", "🔢 Quantity", "💲 Price");
   static final String MESSAGE1 = "💸 How much gold are you investing today?";
   static final String MESSAGE2 = "💼 Fun fact: Our system's wallet is fatter than yours and can hold up to $1000.";
   static final String MESSAGE3 = "💰 Drop in up to $100 at a time. We aren't greedy... much.";
   static final String MESSAGE4 = "🙏 Your coins are safe with us! Thank you for choosing our vending machine!";
   static final String CHOICE_OPTION = "🔄 Decisions, decisions... Please select an option: ";
   static final String MAX = "🚫 Whoa there, cowboy! You've tried too many times. Chill and try again later.";
   static final String IOFILENAME = "📁 Type in the secret scroll's name (or type 'quit' to bail): ";
   static final String NEGATIVE_ENTRY_MSG = "😅 Going negative, huh? No worries! We'll default you to 20 items.";
   static final String EXCEED_LIMIT_MSG = "💼 Wowza! You're a baller. But let's limit that to 100 items.";
   static final String[] CHOICE_MAIN = {"📦 Show Inventory", "💸 Make Sale", "🚪 Quit"};
   static final String[] CHOICE_SECOND = {"💰 Insert Money", "🍬 Pick Your Items",
           "🛍️ Checkout", "🔙 Back to Main Menu"};
   static final String SELECT_OPTIONS = "🤹‍♂️ Life is full of choices! Here are some to choose from:\n";
   public static final String[] CAVE_JOHNSON_QUOTES = {
           "🤹‍♂️ Life's like a box of combustible lemons. Make life take them back!",
           "🚀 Science isn’t about WHY. It’s about WHY NOT!",
           "🔬 Remember: we're throwing science at the wall and seeing what sticks.",
           "🧪 If life gives you lemons, don’t make lemonade! Get mad! Demand to see life’s manager!",
           "🔥 Burn life's house down! With the lemons!",
           "💡 We're not just doing science for the thrill of it. Okay, maybe we are.",
           "🤖 Fact: Space does not exist. Just kidding! Or am I?",
           "🌍 Earth's gravity is a habit you should consider breaking.",
           "🎩 Put on your lab coat and hold onto your hats. Things are about to get... scientifically wild!",
           "🎤 Always remember, if you hear a buzzer, it's not a radio show - it's SCIENCE!"
   };
      public static final String[] OTHER_CHOICES = {
              "🤹‍♂️ Choices, choices! Like deciding between regular lemons and combustible ones!",
              "🚀 Picking options? Just think of it like choosing which science to toss at the wall today!",
              "🔬 Why pick the easy way when you can choose the SCIENTIFIC way? Go on, make a selection.",
              "🧪 Lemons or no lemons? That's a choice! And remember, if life hands you lemons, demand a refund... or a manager!",
              "🔥 Burn or not burn the house down with lemons? Decisions, decisions...",
              "💡 Every switch here makes something explode. So, which explosion would you prefer today?",
              "🤖 To space or not to space? That's the query! Pick wisely.",
              "🌍 Choose to break gravity or just float around. It's all in the hands... or lack of gravity.",
              "🎩 Would you like to coat the day in science or mystery? The lab coat's ready. Make a pick!",
              "🎤 Alright, tune in! Will it be door A with science or door B with... more science? You decide!"
      };

   public static final String[] PROGRAMMING_CHOICES = {
           "🐛 Bug or feature? Choose wisely and you might just avoid an 'unexpected feature' today!",
           "🖥️ Code or coffee? One runs the machine, the other runs the coder. Make your pick!",
           "🕺 Refactor or dance? Because sometimes, you just gotta dance the bugs away!",
           "🤖 While loop or dance loop? Either way, you're stuck in it until someone breaks!",
           "💡 Tab or space? Choose quickly, before the next code war breaks out!",
           "👾 Miss a semicolon? Choose where to put it and watch the world burn... or just your code.",
           "💻 Infinite loop or infinite coffee? Both keep running. Choose your fix!",
           "🎩 Magic code or tragic code? It’s all about perspective and your choice!",
           "🎤 Drop the table or drop the mic? Be careful, one might lead to job openings!",
           "🚀 Ship it or skip it? Sometimes it's hard to choose between launching rockets or rock(et) naps!",
           "🔍 Binary search or blind guess? Either way, let's find that elusive bug!",
           "📜 Recursion or inception? Dive deep, but remember to come back up!",
           "🐍 Python or actual snake? Watch your step, both can be slippery!",
           "🌳 Tree traversal or time travel? Sometimes it's hard to tell which takes longer!",
           "🔥 Git commit or admit defeat? Sometimes you just have to roll with the punches (or pushes)!",
           "💾 Save early or pray later? Remember, autosave is for the weak... and the wise.",
           "🔗 Linked list or missing link? We've all been there. Choose your adventure!",
           "🕶️ Dark mode or... just kidding, always dark mode. But hey, it's your choice!",
           "📦 Stack overflow or coffee overflow? Both can be messy. What's your pick?",
           "📚 Libraries or actual libraries? Both are magical places. Which door will you open?"
   };

   public static final String[] CUSTOMER_GREETINGS = {
           "🌟 Welcome! We're thrilled to see you here!",
           "👋 Hey there! Great to have you with us.",
           "🎉 Glad you stopped by! How can we assist you today?",
           "🌞 Good day! We're at your service.",
           "🚀 Hello and welcome! Ready to embark on a journey with us?",
           "🌈 Greetings! Let's make today a bright and colorful day.",
           "🍀 Hey! Feeling lucky? We're here to help!",
           "🍪 Hello! Fresh out of the oven and ready to assist.",
           "🦉 Wise choice dropping by! What can we do for you?",
           "🎈 Welcome aboard! It's a pleasure to have you.",
           "🌷 Hey there! Blooming good to see you.",
           "🎵 Hello! Tune in to our latest offerings today.",
           "🔔 Ding dong! Your adventure begins now.",
           "🎁 Surprise! Delighted to unwrap your needs today.",
           "🛎️ Checking in? We're here and ready to serve.",
           "🌍 Greetings from all corners! How can we make your day?",
           "🚪 Doors open! Step right in and make yourself comfortable.",
           "🎨 Hello, artist! Let's color your day with joy.",
           "🎟️ Welcome! Grab your ticket to a world of wonders.",
           "🥳 Party's on! Thrilled to celebrate the day with you."
   };

   public static final String[] CUSTOMER_NAME_GREETINGS = {
           "🌟 Hello, %s! Wonderful to see you again!",
           "👋 Hey %s! We've been expecting you.",
           "🎉 Oh, it's %s! Thanks for gracing us with your presence.",
           "🌞 Good day, %s! How's everything going?",
           "🚀 %s! Ready for another fantastic experience with us?",
           "🌈 Greetings, %s! Hope this visit adds color to your day.",
           "🍀 Oh look, it's %s! Today just got luckier.",
           "🍪 Freshly baked welcomes for you, %s!",
           "🦉 Wise as ever, %s! What brings you in today?",
           "🎈 There's a special energy when %s walks in.",
           "🌷 %s, blossoming as always! How can we assist you?",
           "🎵 %s, your presence is music to our ears.",
           "🔔 Ding dong! %s is in the house!",
           "🎁 What a gift to see %s today!",
           "🛎️ %s, checking in? We're all ears!",
           "🌍 From all corners, we've heard tales of %s.",
           "🚪 Doors swing wide open for %s. Welcome back!",
           "🎨 Ah, %s! Painting our day with your vibrant energy.",
           "🎟️ %s, your ticket to today's wonders is right here.",
           "🥳 Every day's a party with %s around!"
   };

   public static final String[] programmerGreetings = {
           "🌍 Hello, World! ...again.",
           "🤔 I see you're still trying to compile that code.",
           "☕🐛 May your coffee be strong and your bugs be minimal!",
           "😜 404: Greeting not found... Just kidding! Hey there!",
           "🔌 Have you tried turning it off and on again?",
           "😉 Greetings, fellow semicolon hunter.",
           "💯 In a world of 0s and 1s, you're a solid 10.",
           "🐞☕ May your code be bug-free and your coffee cup never empty.",
           "😅 Found you! Unlike that missing semicolon...",
           "🤣 Brace yourself, programming jokes are coming.",
           "💻 Just dropping a breakpoint in your day to say hello!",
           "🐄 Knock, knock. Who's there? [interrupting cow in binary].",
           "📚 Here's a greeting from one end of the stack to the other.",
           "🤗 if (feelingDown) { return greeting.hug(); }",
           "🌟 You deserve an array of compliments!",
           "😂 Let's have a byte of fun today!",
           "⬆️⬇️ Wishing you a day with more up-time than down-time.",
           "💼 You’re the type of friend I wouldn’t mind sharing my source code with.",
           "🐱 /\\_/\\ \n( o.o ) > Hello from ASCII Cat!",
           "🆘 In case of emergency, `git commit -m 'Help!' && git push`"
   };

   public static String[] wrongInputGreetings = {
           "🤖 Oops! Seems like you misplaced a bit.",
           "🤷‍♂️ Did you try to input something or was that just a wild keyboard dance?",
           "🧐 That input wasn't in the script. Improvising...",
           "🚫 404: Selection not found. But hey, keep trying!",
           "😬 Looks like that choice wasn't on the menu... or any menu I know of.",
           "🕵️‍♂️ Searching for your selection... Still searching... Nope, can't find it.",
           "🙈 Error: Invalid input. Or was it a secret code?",
           "😉 That choice isn't binary-approved. Try another.",
           "💡 Tip: Selecting from available options increases success rate!",
           "🎲 You rolled a natural 1. Try again.",
           "😯 Seems like you're exploring uncharted territories of our inventory.",
           "💻 Console says 'no', but I believe in you!",
           "🤔 Invalid choice. Maybe you're thinking in a higher-level language?",
           "📖 Input not found in my documentation. But I'm curious now.",
           "🛸 That choice is out of this world. And out of this list.",
           "🔍 That wasn't in the array. Did you perhaps drop it in another dimension?",
           "🎈 Unexpected input! But everything's a surprise party with you.",
           "🛠️ Time for some debugging! Or just pick from the list...",
           "🌌 Error: Selection not in this universe. Portal gun required.",
           "🎉 Surprise! That input isn't valid. But I admire your creativity!"
   };

   public static String[] insufficientFundsGreetings = {
           "💸 Error 402: Payment Required. Insert coin to continue.",
           "🤖 Running low on credits? Did someone initiate a DDoS on your wallet?",
           "💰 `console.warn('Insufficient gold coins.');` Time to farm some more!",
           "🧐 Seems your account balance returned `null`. Consider a recharge?",
           "🚫 ByteCoinException: Not enough bytes in your e-wallet.",
           "😉 Your funds seem to have gone on a coffee break. Fetch them back?",
           "💳 Your credit card just threw an `UnderflowException`.",
           "🎮 In RPG terms, you need more gold. Quest time?",
           "😅 Transaction denied. Maybe your funds are stuck in a parallel universe?",
           "🔍 Searching for funds... Error: Wallet underflow detected.",
           "🤔 Did you check under the couch? That's where I find my lost bits.",
           "🕵️‍♂️ Your bank called. They're looking for the missing funds too.",
           "💾 Saving transaction... Oh wait, insufficient funds. Try defragmenting your wallet?",
           "🎈 Looks like your funds are floating away. Time to anchor them down?",
           "🛸 Beam me up, Scotty! And bring some more cash while you're at it.",
           "💼 BudgetOverflowError: You might need to refactor your expenses.",
           "⛔️ Funds not found. But I believe in the power of budgeting!",
           "💡 Remember: Just like in coding, sometimes you need to debug your finances.",
           "⌛ Waiting for funds to load... Still waiting...",
           "🎉 Surprise! You need more credits. But every penny counts, right?"
   };




   static final String[] FILE_CHOICE = new String[] {"Use your own file?", "Use randomly generated items?", "Use the default file? IE inventory.csv"};

   public void error2(){
      String art = "                                           \\ / _\n" +
              "                                      ___,,,\n" +
              "                                      \\_[o o]\n" +
              "     Errare humanum est!              C\\  _\\/\n" +
              "             /                     _____),_/__\n" +
              "        ________                  /     \\/   /\n" +
              "      _|       .|                /      o   /\n" +
              "     | |       .|               /          /\n" +
              "      \\|       .|              /          /\n" +
              "       |________|             /_        \\/\n" +
              "       __|___|__             _//\\        \\\n" +
              " _____|_________|____       \\  \\ \\        \\\n" +
              "                    _|       ///  \\        \\\n" +
              "                   |               \\       /\n" +
              "                   |               /      /\n" +
              "                   |              /      /\n" +
              " ________________  |             /__    /_\n" +
              " b'ger        ...|_|.............. /______\\.......";
      System.out.println(art);

   }

     public static String errorBig =  "███████╗██████╗ ██████╗  ██████╗ ██████╗ \n" +
              "██╔════╝██╔══██╗██╔══██╗██╔═══██╗██╔══██╗\n" +
              "█████╗  ██████╔╝██████╔╝██║   ██║██████╔╝\n" +
              "██╔══╝  ██╔══██╗██╔══██╗██║   ██║██╔══██╗\n" +
              "███████╗██║  ██║██║  ██║╚██████╔╝██║  ██║\n" +
              "╚══════╝╚═╝  ╚═╝╚═╝  ╚═╝ ╚═════╝ ╚═╝  ╚═╝";

   public static String thankyou = "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⣤⣀⢠⡤⠤⠖⠒⠒⠒⠲⣆⠀⠀⠀⠀⣾⠋⠉⠉⠛⢷⠀⣴⠖⠒⠤⣄⠀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
           "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣤⠤⠶⢺⣾⣏⠁⠀⠀⣧⣼⣇⣀⠀⠀⠀⡀⠀⠘⡆⠀⠀⢰⣏⠀⠀⠀⠀⠘⣿⡟⠀⠀⢠⢃⣼⡏⠉⠙⢳⡆⠀⠀⠀⠀⠀⠀⠀⠀\n" +
           "⠀⠀⠀⠀⣀⡤⠴⠒⠋⠙⣇⣿⠀⠀⠀⣿⣿⠀⠀⠀⢸⣿⣿⣿⠃⠀⢰⣿⡀⠀⠹⡄⠀⢸⣿⠀⠀⠀⠀⠀⢹⡇⠀⠀⢸⡿⣽⠀⠀⠀⡜⠀⣀⡤⠖⠓⠢⢤⣀⠀\n" +
           "⣠⡴⠒⠉⠁⠀⠀⠀⠀⠀⠸⣿⡇⠀⠀⠘⠛⠃⠀⠀⠈⡟⠉⣿⠀⠀⠘⠛⠃⠀⠀⢷⠀⢸⣿⠀⠀⢠⡀⠀⠀⠀⠀⠀⣿⢧⡇⠀⠀⠸⠗⠚⠁⠀⠀⠀⣀⣠⣾⠃\n" +
           "⣿⡇⠀⠀⠀⠀⠀⠀⣶⣶⣿⢿⢹⠀⠀⠀⢀⣀⠀⠀⠀⢳⠀⣿⠀⠀⢀⣀⣤⠀⠀⠘⣇⢸⡏⠀⠀⢸⣧⠀⠀⠀⠀⢸⣿⡿⠀⠀⢀⠀⠀⠀⢀⣤⣶⣿⠿⠛⠁⠀\n" +
           "⢧⣹⣶⣾⣿⡄⠀⠀⠸⡟⠋⠘⡜⡆⠀⠀⢻⣿⡇⠀⠀⢸⡀⣿⠀⠀⢸⣿⡿⡇⠀⠀⢸⣿⡇⠀⠀⢸⡿⡆⠀⠀⠀⣾⣿⠃⠀⠀⣾⡇⠀⠀⠈⡟⠉⠀⠀⠀⠀⠀\n" +
           "⠘⣿⡿⠿⢿⣧⠀⠀⠀⢳⡀⠀⣇⢱⠀⠀⠈⣿⣷⠀⣀⣸⣷⣿⣤⣤⣼⠋⣇⣹⣶⣶⣾⣿⡿⢲⣶⣾⡇⣿⣤⣀⣀⣿⡏⠀⠀⣼⡏⢧⠀⠀⠀⣇⠀⠀⠀⠀⠀⠀\n" +
           "⠀⠀⠀⠀⠸⡞⣇⠀⠀⠀⢧⠀⢸⣈⣷⣶⣶⣿⣿⣿⣿⣿⣿⣿⣽⣿⡏⢀⡼⠟⠛⠻⢿⡿⠿⠿⣿⣁⣿⣿⣿⣿⣿⣿⣿⣶⣴⢿⠁⢸⠀⠀⠀⢸⠀⠀⠀⠀⠀⠀\n" +
           "⠀⠀⠀⠀⠀⢹⣼⣦⣤⣶⣿⠁⣀⣿⠿⠿⣿⣫⣿⠉⠁⠀⠀⠀⡏⠀⣴⠏⠀⠀⠀⠀⠀⠹⣆⠀⢠⣿⠀⠀⠀⢈⠟⢻⡿⠿⣅⣘⡆⣸⣇⠀⠀⢸⠀⠀⠀⠀⠀⠀\n" +
           "⠀⠀⠀⠀⠀⠀⠻⠿⠿⠛⠃⢠⣿⣷⣄⠀⠈⠙⠋⠀⠀⠀⠀⣸⢁⡾⠁⠀⠀⣠⣤⡀⠀⠀⠸⣤⡞⡇⠀⠀⠀⢸⣰⣿⠃⠀⠀⢹⣿⣿⣿⣿⣦⣼⠀⠀⠀⠀⠀⠀\n" +
           "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠻⢿⣿⣿⣷⣄⠀⠀⠀⠀⠀⠀⣿⣾⠇⠀⠀⣸⣿⣿⢿⠀⠀⠀⣿⢁⡇⠀⠀⢀⣿⣿⡏⠀⠀⠀⡼⠀⢙⣿⠛⠻⣏⡀⠀⠀⠀⠀⠀\n" +
           "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⢿⣿⣿⣷⠀⠀⠀⠀⢸⡿⡿⠀⠀⠀⡏⢹⠟⡟⠀⠀⠀⡿⢸⠀⠀⠀⢸⣿⡿⠀⠀⠀⢠⠇⡰⢋⡏⠀⠀⠀⢙⡆⠀⠀⠀⠀\n" +
           "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⡿⡿⠀⠀⠀⠀⣸⡇⡇⠀⠀⠀⠻⠾⠞⠁⠀⠀⢀⡇⡏⠀⠀⠀⢸⣿⠃⠀⠀⠀⡼⣰⠃⡞⠀⠀⠀⠀⡾⠁⠀⠀⠀⠀\n" +
           "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⡇⡇⠀⠀⠀⠀⣿⣇⣷⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⣃⡇⠀⠀⠀⠀⠀⠀⠀⠀⣼⣷⠃⣼⡀⠀⠀⢀⡞⠁⠀⠀⠀⠀⠀\n" +
           "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⢸⠃⠀⠀⠀⢀⡇⢿⣿⣧⣀⠀⠀⠀⠀⠀⣠⣾⣿⣿⣧⠀⠀⠀⠀⠀⠀⠀⣸⣿⣿⣿⣽⣿⣷⣤⡞⠁⠀⠀⠀⠀⠀⠀\n" +
           "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣾⣼⣤⣶⣶⣶⡿⠁⠈⢿⣿⣿⣿⣿⣿⣿⣿⠿⠃⢸⣿⣿⣷⣤⣄⣀⣀⣤⣾⣏⣤⡟⠁⠀⠈⠻⡍⠀⠀⠀⠀⠀⠀⠀⠀\n" +
           "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⠿⠿⠿⠟⠛⠁⠀⠀⠀⠉⠛⠛⠛⠛⠉⠁⠀⠀⠀⠙⠿⢿⣿⣿⡿⠿⠋⢀⣿⣿⣧⡀⠀⠀⣠⡇⠀⠀⠀⠀⠀⠀⠀⠀\n" +
           "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢿⣿⣿⣿⣿⠟⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀";




}


