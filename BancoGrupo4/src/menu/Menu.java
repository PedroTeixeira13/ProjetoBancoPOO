package menu;

public class Menu {
	
	public final static void logo() {
		
		System.out.println(
				  ".....................................:===:......................................\r\n"
				+ ".................................-*###++=##*:..................................\r\n"
				+ "..............................:=##*-......-+###*-..............................\r\n"
				+ "..........................-*##=:.....+=#*-....-*###+-..........................\r\n"
				+ ".......................+=##*-....:=##=:-+###*-....-*##=+-......................\r\n"
				+ "...................:=##=:....-*###+:*#####+-*###+-....:=##=:...................\r\n"
				+ "...............-+###+-....:=##*-+###+-...-*##=+:*##=+.....:=##=:...............\r\n"
				+ "............:=##*-......+#=::=##=:...........:=##=::=#*.......+=##*-...........\r\n"
				+ "........-*##=:..........:###=+...................+=###+..........-+###*-.......\r\n"
				+ ".......:#=-.....................$$SERRA BANK$$.......................-=#:......\r\n"
				+ ".......:#*............................................................*#:......\r\n"
				+ ".......:################################################################:......\r\n"
				+ "...........-#=.............##-....................-#=.............=#-..........\r\n"
				+ "...........-#=-------------##-.........**.........-##-------------=#-..........\r\n"
				+ "............*==#=========#==*.........-##-.........*==#=========#==*...........\r\n"
				+ "..............*#:.......+#+.........*######*.........+#+.......+#*.............\r\n"
				+ "..............*#:.......+#+........*#:.##.+#*........+#+.......+#*.............\r\n"
				+ "..............*#:.......+#+........*#:.##..+:........+#+.......+#*.............\r\n"
				+ "..............*#:.......+#+.........=#=##:...........+#+.......+#*.............\r\n"
				+ "..............*#:.......+#+...........-##=#=-........+#+.......+#*.............\r\n"
				+ "..............*#:.......+#+........+*..##.:#=........+#+.......+#*.............\r\n"
				+ "..............*#:.......+#+........*#+.##.+#*........+#+.......+#*.............\r\n"
				+ "..............*#:.......+#+.........*######*.........+#+.......+#*.............\r\n"
				+ "..............*#:.......+#+............##............+#+.......+#*.............\r\n"
				+ "..............*#:.......+#+............++............+#+.......+#*.............\r\n"
				+ "..............*#:.......+#+..........................+#+.......+#*.............\r\n"
				+ "........-=############################################################=-.......\r\n"
				+ ".......-##-..........................................................-##-......\r\n"
				+ ".......-#=............................................................=#-......\r\n"
				+ "....=######################################################################=...\r\n"
				+ "...+#+....................................................................+#+..\r\n"
				+ "...-=######################################################################=-..\r\n"
				+ "...-=#################...Seja Bem-vindo(a) ao Serra Bank...################=-..\r\n");
	}
	
	public static void sair() throws InterruptedException {
		System.out.print("-------------\n");
		System.out.print("Saindo");
		Thread.sleep(500);
		System.out.print(".");
		Thread.sleep(500);
		System.out.print(".");
		Thread.sleep(500);
		System.out.println(".");
		Thread.sleep(500);
		System.out.print("-------------\n");
		System.out.println("\nObrigado por utilizar o nosso Banco!\n");
	}
}
