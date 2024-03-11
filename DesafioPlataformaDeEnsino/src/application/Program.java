package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Lesson;
import entities.Task;
import entities.Video;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Lesson> list = new ArrayList<>();
		
		System.out.print("Quantas aulas tem o curso? ");
		int N = sc.nextInt();
		
		for (int i = 0; i < N; i++) {
			System.out.printf("Dados da %da aula: \n", i+1);
			
			System.out.print("Conteúdo ou tarefa (c/t)? ");
			char option = sc.next().charAt(0);
			
			System.out.print("Título: ");
			String title = sc.nextLine();
			sc.nextLine();
			
			if (option == 'c') {
				System.out.print("URL do vídeo: ");
				String url = sc.nextLine();
				
				System.out.print("Duração em segundos: ");
				int duration = sc.nextInt();
				
				list.add(new Video(title, url, duration));
			} else {
				System.out.print("Descrição: ");
				String description = sc.nextLine();
				
				System.out.print("Quantidade de questões: ");
				int questions = sc.nextInt();
				
				list.add(new Task(title, description, questions));
			}			
		}
		
		System.out.println();
		System.out.print("Duração total do curso = ");
		int duration = 0;
		for (Lesson lesson: list) {
			duration += lesson.duration();
		}
		System.out.println(duration + " segundos");
		
		sc.close();

	}

}
