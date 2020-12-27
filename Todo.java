import java.io.*;
import java.util.*;

public class Todo {

	static ArrayList<String> todo = new ArrayList<String>();
	static ArrayList<String> done = new ArrayList();

	void help() {
		System.out.println("Usage :- ");
		System.out.println("./todo add \"todo item\"  # Add a new todo");
		System.out.println("./todo ls               # Show remaining todos");
		System.out.println("./todo del NUMBER       # Delete a todo");
		System.out.println("./todo done NUMBER      # Complete a todo");
		System.out.println("./todo help             # Show usage");
		System.out.println("./todo report           # Statistics");
	}

	void ls() {
		for (int i = todo.size() - 1; i >= 0; i--) {
			System.out.println("[" + (i + 1) + "] " + todo.get(i));
		}
	}

	void add(String s) {
		System.out.println("Added todo: \"" + s + "\"");
		todo.add(s);
	}

	void del(int n) {
		if (n - 1 < todo.size()) {
			todo.remove(n - 1);
			System.out.println("Deleted todo #" + n);
		} else {
			System.out.println("Error: todo #" + n + " does not exist. Nothing deleted.");
		}
	}

	void report() {
		System.out.println("Pending : " + todo.size() + " Completed : " + done.size());
	}

	void done(int n) {
		if (n - 1 <= todo.size()) {
			done.add(todo.get(n - 1));
			todo.remove(n - 1);
			System.out.println("Marked todo #" + n + " as done.");
		} else {
			System.out.println("Error: todo #" + n + "does not exist.");
		}
	}

	public static void main(String args[]) {
		Todo app = new Todo();
		Scanner in = new Scanner(System.in);
		while (true) {
			String a = in.nextLine();
			String[] ab = a.split(" ");
			if (ab[0].equals("help")) {
				app.help();
			} else if (ab[0].equals("ls")) {
				app.ls();
			} else if (ab[0].equals("del")) {
				int a1 = Integer.parseInt(ab[1]);
				app.del(a1);
			} else if (ab[0].equals("done")) {
				int a2 = Integer.parseInt(ab[1]);
				app.done(a2);
			} else if (ab[0].equals("report")) {
				app.report();
			} else if (ab[0].equals("add")) {
				String toadd = "";
				for (int i = 1; i < ab.length; i++) {
					toadd += ab[i] + " ";
				}
				System.out.println("Added todo: \"" + toadd.substring(0, toadd.length() - 1) + "\"");
				todo.add(toadd);
			} else if (ab[0].equals("exit")) {
				break;
			} else {
				System.out.println("Not Found");
			}
		}
	}
}
