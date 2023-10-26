package application;
	
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class Main extends Application {
	File f2 ;
	@Override
	public void start(Stage primaryStage) {
		try {
		
			AVLTree m=new AVLTree();
			AVL v=new AVL();
			BorderPane root = new BorderPane();
			GridPane g=new GridPane();
			Button read=new Button("Read Data");
			read.setMinWidth(200);
			read.setFont(Font.font(15));
			read.setFont(Font.font(null, FontWeight.BOLD, read.getFont().getSize()));
			read.setMinWidth(400);
			read.setMinHeight(50);
			g.add(read, 0, 0);
			Button insert =new Button("Insert a new Department");
			insert.setMinWidth(200);
			insert.setFont(Font.font(15));
			insert.setFont(Font.font(null, FontWeight.BOLD, insert.getFont().getSize()));
			insert.setMinWidth(400);
			insert.setMinHeight(50);
			g.add(insert, 0, 1);
			Button insertt =new Button("insert a new Student to specific Department");
			insertt.setMinWidth(200);
			insertt.setFont(Font.font(15));
			insertt.setFont(Font.font(null, FontWeight.BOLD, insertt.getFont().getSize()));
			insertt.setMinWidth(400);
			insertt.setMinHeight(50);
			g.add(insertt, 0, 2);
			Button delete=new Button("Delete a Specific Department");
			delete.setMinWidth(200);
			delete.setFont(Font.font(15));
			delete.setFont(Font.font(null, FontWeight.BOLD, delete.getFont().getSize()));
			delete.setMinWidth(400);
			delete.setMinHeight(50);
			g.add(delete, 0, 3);
			Button deletee=new Button("Delete a Student for Specific Department");
			deletee.setMinWidth(200);
			deletee.setFont(Font.font(15));
			deletee.setFont(Font.font(null, FontWeight.BOLD, deletee.getFont().getSize()));
			deletee.setMinWidth(400);
			deletee.setMinHeight(50);
			g.add(deletee, 0, 4);
			Button Search=new Button("Search for Specific Department");
			Search.setMinWidth(200);
			Search.setFont(Font.font(15));
			Search.setFont(Font.font(null, FontWeight.BOLD, Search.getFont().getSize()));
			Search.setMinWidth(400);
			Search.setMinHeight(50);
			g.add(Search, 0, 5);
			Button Searchh=new Button("Search for Student in a Specifc Department");
			Searchh.setMinWidth(200);
			Searchh.setFont(Font.font(15));
			Searchh.setFont(Font.font(null, FontWeight.BOLD, Searchh.getFont().getSize()));
			Searchh.setMinWidth(400);
			Searchh.setMinHeight(50);
			g.add(Searchh, 0, 6);
			Button print=new Button("Print Departements");
			print.setMinWidth(200);
			print.setFont(Font.font(15));
			print.setFont(Font.font(null, FontWeight.BOLD, print.getFont().getSize()));
			print.setMinWidth(400);
			print.setMinHeight(50);
			g.add(print, 0, 7);
			Button printt=new Button("Print Hash Table for student in specific Departement");
			printt.setMinWidth(200);
			printt.setFont(Font.font(15));
			printt.setFont(Font.font(null, FontWeight.BOLD, printt.getFont().getSize()));
			printt.setMinWidth(400);
			printt.setMinHeight(50);
			g.add(printt, 0, 8);
			
			
			g.setAlignment(Pos.CENTER);
			g.setHgap(5);
			g.setVgap(15);
		
			root.setStyle("-fx-background-color:MOCCASIN;");
			
			m.printTree();
			System.out.print(m.height());
			root.setCenter(g);
			Scene scene = new Scene(root,1550,800);
			scene.setFill(Color.MOCCASIN);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			Image image1 = new Image("plus.png");
			Button btt = new Button("", new ImageView(image1));
			btt.setMinHeight(50);
			btt.setMinWidth(30);
			btt.setAlignment(Pos.CENTER);
			 
			read.setOnAction(new EventHandler<ActionEvent>() {
			
				@Override
				public void handle(ActionEvent arg0) {
					
					FileChooser fc = new FileChooser();
					f2= fc.showOpenDialog(primaryStage);
				
					try {
						if (f2.length() != 0) {
							Scanner input2;
							try {
								input2 = new Scanner(f2);
								while (input2.hasNext()) {
									String Data = input2.nextLine();
									
									String[] token = Data.trim().split("/");
                                     
									Department d = new Department((token[0].trim()), token[1].trim());
									//m.insert(d);
									
									v.insert(d);
									
									
							
									
									if (d.getFilee().exists()) {
										Scanner myReader = new Scanner(d.getFilee());
											
											while (myReader.hasNext()) {
												String data = myReader.nextLine();
												data=data.trim();
												String[] tokens = data.split("/");
												d.m.insert(new Student(tokens[0].trim(),tokens[1].trim(),Double.parseDouble(tokens[2].trim()),tokens[3].trim()));
											
											}
											
											myReader.close();
										
									}

								}
							} catch (FileNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}

					} catch (NullPointerException e) {
						// TODO Auto-generated catch block

						

					}
					catch (ArrayIndexOutOfBoundsException e) {
						// TODO Auto-generated catch block

						

					}
					

				}
			});

             insert.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent arg0) {
					BorderPane o = new BorderPane();
					o.setStyle("-fx-background-color: MOCCASIN;");
					GridPane g = new GridPane();
					Label name= new Label("Department Name:");
					TextField bt=new TextField();
					name.setFont(Font.font(15));
					name.setFont(Font.font(null, FontWeight.BOLD, name.getFont().getSize()));
					g.add(name, 0, 0);
					g.add(bt, 1, 0);
					Label flnu = new Label("Department File:");
					TextField b=new TextField();
					flnu.setFont(Font.font(15));
					flnu.setFont(Font.font(null, FontWeight.BOLD, flnu.getFont().getSize()));
					g.add(flnu, 0, 1);
					g.add(b, 1, 1);
					RadioButton check=new RadioButton("Calculate Tree Height");
					check.setFont(Font.font(15));
					check.setFont(Font.font(null, FontWeight.BOLD,check.getFont().getSize()));
					
					g.add(check, 0, 2);
					check.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent arg0) {
							TextField heightt=new TextField();
							heightt.setFont(Font.font(15));
							heightt.setFont(Font.font(null, FontWeight.BOLD,heightt.getFont().getSize()));
							heightt.setText(String .valueOf(v.height()));
							g.add(heightt, 1, 2);
							System.out.print(v.traverseInOrder());
							
						}
						
					});
					
					
			
					g.setAlignment(Pos.CENTER);
					g.setHgap(5);
					g.setVgap(20);
					o.setCenter(g);
					Image image33 = new Image("back.png");
					Button b2 = new Button("", new ImageView(image33));
					b2.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent arg0) {
							
							primaryStage.setScene(scene);

						}

					});
					btt.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent arg0)  {
							if(m.search(bt.getText())==null) {
								Department x= new Department(bt.getText().trim(),b.getText().trim());
								// m.insert(x);
								 v.insert(x);
								if (x.getFilee().exists()) {
									try {
										Scanner myReader = new Scanner(x.getFilee());

										while (myReader.hasNext()) {
											String data = myReader.nextLine();
											String[] tokens = data.split("/");
										
											x.m.insert(new Student(tokens[0].trim(),tokens[1].trim(),Double.parseDouble(tokens[2].trim()),tokens[3].trim()));
										
										}
										m.printTree();
										x.m.printHashTable();
										myReader.close();
										FileWriter writer;
										writer = new FileWriter(f2, true);
								     	String r=bt.getText()+"/"+b.getText()+"\n";
										writer.write(r);
										writer.close();
									} catch (Exception e) {
										e.printStackTrace();
									}
									
									
								} 
								
			
						
							}else {
								System.out.print("this departement is already exict");
							}
							
						}
						
					});
					HBox h=new HBox();
					h.getChildren().addAll(btt,b2);
					h.setAlignment(Pos.CENTER);
					o.setBottom(h);
					Scene scene = new Scene(o, 1550, 800);
					primaryStage.setScene(scene);
					primaryStage.show();

				}
			});
             insertt.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					BorderPane o = new BorderPane();
					o.setStyle("-fx-background-color: MOCCASIN;");
					GridPane g = new GridPane();
					Label name= new Label("Department Name:");
					TextField bt=new TextField();
					name.setFont(Font.font(15));
					name.setFont(Font.font(null, FontWeight.BOLD, name.getFont().getSize()));
					g.add(name, 0, 0);
					g.add(bt, 1, 0);
					Label stu= new Label("Student Name:");
					TextField stuu=new TextField();
					stu.setFont(Font.font(15));
					stu.setFont(Font.font(null, FontWeight.BOLD, name.getFont().getSize()));
					g.add(stu, 0, 1);
					g.add(stuu, 1, 1);
					Label id= new Label("Student ID:");
					TextField idd=new TextField();
					id.setFont(Font.font(15));
					id.setFont(Font.font(null, FontWeight.BOLD, name.getFont().getSize()));
					g.add(id, 0, 2);
					g.add(idd, 1, 2);
					Label avg= new Label("Student Averge:");
					TextField avgg=new TextField();
					avg.setFont(Font.font(15));
					avg.setFont(Font.font(null, FontWeight.BOLD, name.getFont().getSize()));
					g.add(avg, 0, 3);
					g.add(avgg, 1, 3);
					Label gender= new Label("Student Gender:");
					TextField gg=new TextField();
					gender.setFont(Font.font(15));
					gender.setFont(Font.font(null, FontWeight.BOLD, name.getFont().getSize()));
					g.add(gender, 0, 4);
					g.add(gg, 1, 4);
					
					g.setAlignment(Pos.CENTER);
					g.setHgap(5);
					g.setVgap(20);
					o.setCenter(g);
					Image image33 = new Image("back.png");
					Button b2 = new Button("", new ImageView(image33));
					b2.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent arg0) {
							
							primaryStage.setScene(scene);

						}

					});
					btt.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent arg0) {
                           TNode b =v.find(bt.getText().trim());
							
					    	if(b!=null) {
							if(b.data.m.find(stuu.getText())==null) {
								b.data.m.insert(new Student(stuu.getText(),idd.getText(),Double.parseDouble(avgg.getText()),gg.getText()));
								FileWriter writer;
								try {
									writer = new FileWriter(b.data.getFilee(), true);
									String r=stuu.getText()+"/"+idd.getText()+"/"+avgg.getText()+"/"+gg.getText()+"\n";
									writer.write(r.trim());
									writer.close();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
						     	
							}
						}
							
						
						}
						
					});
					
					HBox h=new HBox();
					h.getChildren().addAll(btt,b2);
					h.setAlignment(Pos.CENTER);
					o.setBottom(h);
					Scene scene = new Scene(o, 1550, 800);
					primaryStage.setScene(scene);
					primaryStage.show();

				
					
				}
            	 
			});
             delete.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					BorderPane o = new BorderPane();
					o.setStyle("-fx-background-color: MOCCASIN;");
					GridPane g = new GridPane();
					Label name= new Label("Department Name : ");
					TextField bt=new TextField();
					name.setFont(Font.font(15));
					name.setFont(Font.font(null, FontWeight.BOLD, name.getFont().getSize()));
					g.add(name, 0, 0);
					g.add(bt, 1, 0);
					Label mess= new Label("Message  : ");
					TextField msgg=new TextField();
					mess.setFont(Font.font(15));
					mess.setFont(Font.font(null, FontWeight.BOLD, mess.getFont().getSize()));
					msgg.setFont(Font.font(15));
					msgg.setFont(Font.font(null, FontWeight.BOLD, msgg.getFont().getSize()));
					g.add(mess, 0, 1);
					g.add(msgg, 1, 1);
					
					g.setAlignment(Pos.CENTER);
					g.setHgap(5);
					g.setVgap(20);
					o.setCenter(g);
					Image image33 = new Image("back.png");
					Button b2 = new Button("", new ImageView(image33));
					b2.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent arg0) {
							
							primaryStage.setScene(scene);

						}

					});
					btt.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent arg0) {
							
						
							TNode b =v.find(bt.getText());
							if(b!=null) {
								msgg.setText("It Successfully Deleted");
								v.delete(bt.getText());
								FileWriter writer;
								
									try {
										writer = new FileWriter(f2, false);
										writer.write(v.file());
										writer.close();
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									
								
								
								}else
								{
									msgg.setText("Please TTry again");
								}
					
						
						}
						
					});
					
					HBox h=new HBox();
					h.getChildren().addAll(btt,b2);
					h.setAlignment(Pos.CENTER);
					o.setBottom(h);
					Scene scene = new Scene(o, 1550, 800);
					primaryStage.setScene(scene);
					primaryStage.show();

				
					
				}
            	 
			}
             );
             deletee.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					BorderPane o = new BorderPane();
					o.setStyle("-fx-background-color: MOCCASIN;");
					GridPane g = new GridPane();
					Label name= new Label("Department Name:");
					TextField bt=new TextField();
					name.setFont(Font.font(15));
					name.setFont(Font.font(null, FontWeight.BOLD, name.getFont().getSize()));
					g.add(name, 0, 0);
					g.add(bt, 1, 0);
					Label stu= new Label("Student Name:");
					TextField stuu=new TextField();
					stu.setFont(Font.font(15));
					stu.setFont(Font.font(null, FontWeight.BOLD, name.getFont().getSize()));
					g.add(stu, 0, 1);
					g.add(stuu, 1, 1);
					Label mess= new Label("Message  : ");
					TextField msgg=new TextField();
					mess.setFont(Font.font(15));
					mess.setFont(Font.font(null, FontWeight.BOLD, mess.getFont().getSize()));
					msgg.setFont(Font.font(15));
					msgg.setFont(Font.font(null, FontWeight.BOLD, msgg.getFont().getSize()));
					g.add(mess, 0, 2);
					g.add(msgg, 1, 2);
					
					g.setAlignment(Pos.CENTER);
					g.setHgap(5);
					g.setVgap(20);
					o.setCenter(g);
					Image image33 = new Image("back.png");
					Button b2 = new Button("", new ImageView(image33));
					b2.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent arg0) {
							
							primaryStage.setScene(scene);

						}

					});
					btt.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent arg0) {
							TNode b =v.find(bt.getText());
					    	if(b!=null) {
					    		
							if(b.data.m.find(stuu.getText())!=null) {
								msgg.setText("It is Successfully Deleted ");
								b.data.m.remove(stuu.getText());
								FileWriter writer;
								
								try {
									writer = new FileWriter(b.data.getFilee(), false);
									writer.write(b.data.m.print());
									writer.close();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
						     	
							}else
							{
								msgg.setText("please try again");
							}
						}
						
						}
						
					});
					HBox h=new HBox();
					h.getChildren().addAll(btt,b2);
					h.setAlignment(Pos.CENTER);
					o.setBottom(h);
					Scene scene = new Scene(o, 1550, 800);
					primaryStage.setScene(scene);
					primaryStage.show();
					
				}
            	 
			});
        Search.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				BorderPane o = new BorderPane();
				o.setStyle("-fx-background-color: MOCCASIN;");
				GridPane g = new GridPane();
				Label name= new Label("Department Name : ");
				TextField bt=new TextField();
				name.setFont(Font.font(15));
				name.setFont(Font.font(null, FontWeight.BOLD, name.getFont().getSize()));
				Label mess= new Label("Message : ");
				mess.setFont(Font.font(15));
				mess.setFont(Font.font(null, FontWeight.BOLD, mess.getFont().getSize()));
				TextField find=new TextField();
				g.add(name, 0, 0);
				g.add(bt, 1, 0);
				g.setAlignment(Pos.CENTER);
				g.setHgap(5);
				g.setVgap(20);
				o.setCenter(g);
				Image image33 = new Image("back.png");
				Button b2 = new Button("", new ImageView(image33));
				b2.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent arg0) {
						
						primaryStage.setScene(scene);

					}

				});
				btt.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent arg0) {
						Label mess= new Label("Message : ");
						mess.setFont(Font.font(15));
						mess.setFont(Font.font(null, FontWeight.BOLD, mess.getFont().getSize()));
						TextField findd=new TextField();
						
						findd.setFont(Font.font(15));
						findd.setFont(Font.font(null, FontWeight.BOLD, findd.getFont().getSize()));
						g.add(mess, 0, 1);
						g.add(findd, 1, 1);
						TNode b =v.find(bt.getText());
						  if(b!=null) {
							findd.setText("Found It");
							
							}else {
								findd.setText("Please try again");
							}
				
					}
				});
			
				HBox h=new HBox();
				h.getChildren().addAll(btt,b2);
				h.setAlignment(Pos.CENTER);
				o.setBottom(h);
				Scene scene = new Scene(o, 1550, 800);
				primaryStage.setScene(scene);
				primaryStage.show();

			
				
			}
        	
		});
       Searchh.setOnAction(new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent arg0) {
			BorderPane o = new BorderPane();
			o.setStyle("-fx-background-color: MOCCASIN;");
			GridPane g = new GridPane();
			Label name= new Label("Department Name:");
			TextField bt=new TextField();
			name.setFont(Font.font(15));
			name.setFont(Font.font(null, FontWeight.BOLD, name.getFont().getSize()));
			g.add(name, 0, 0);
			g.add(bt, 1, 0);
			Label stu= new Label("Student Name:");
			TextField stuu=new TextField();
			stu.setFont(Font.font(15));
			stu.setFont(Font.font(null, FontWeight.BOLD, name.getFont().getSize()));
			g.add(stu, 0, 1);
			g.add(stuu, 1, 1);
		
			
			g.setAlignment(Pos.CENTER);
			g.setHgap(5);
			g.setVgap(20);
			o.setCenter(g);
			Image image33 = new Image("back.png");
			Button b2 = new Button("", new ImageView(image33));
			b2.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					
					primaryStage.setScene(scene);

				}

			});
			btt.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					Label me= new Label("Message :");
					TextField mess=new TextField();
					mess.setFont(Font.font(15));
					mess.setFont(Font.font(null, FontWeight.BOLD, mess.getFont().getSize()));
					me.setFont(Font.font(15));
					me.setFont(Font.font(null, FontWeight.BOLD, me.getFont().getSize()));
					g.add(me, 0, 2);
					g.add(mess, 1, 2);
						TNode t=v.find(bt.getText());
					if(t!=null) {
						if(t.data.m.find(stuu.getText())!=null) {
							mess.setText("Found It");
						}else
						{
							mess.setText("Please Try again");
						}
					}
				/*AVLNode t=m.search(bt.getText());
					if(t!=null) {
						if(t.data.m.find(stuu.getText())!=null) {
							mess.setText("Found It");
						}else
						{
							mess.setText("Please Try again");
						}
					}	*/
				
				}
				
			});
			
			HBox h=new HBox();
			h.getChildren().addAll(btt,b2);
			h.setAlignment(Pos.CENTER);
			o.setBottom(h);
			Scene scene = new Scene(o, 1550, 800);
			primaryStage.setScene(scene);
			primaryStage.show();

		
			
			
		}
    	   
	});
       print.setOnAction(new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent arg0) {
			BorderPane o = new BorderPane();
			o.setStyle("-fx-background-color: MOCCASIN;");
			GridPane g = new GridPane();
			TextArea area1 = new TextArea();
			area1.setPrefWidth(1000);
			area1.setPrefHeight(500);
			area1.setFont(Font.font(15));
			area1.setFont(Font.font(null, FontWeight.BOLD, area1.getFont().getSize()));
			
			area1.setText(v.traverseInOrder());
			g.add(area1, 0, 2);
			g.setAlignment(Pos.CENTER);
			g.setHgap(5);
			g.setVgap(20);
			o.setCenter(g);
			Image image33 = new Image("back.png");
			Button b2 = new Button("", new ImageView(image33));
			b2.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					
					primaryStage.setScene(scene);

				}

			});
			
			HBox h=new HBox();
			h.getChildren().addAll(b2);
			h.setAlignment(Pos.CENTER);
			o.setBottom(h);
			Scene scene = new Scene(o, 1550, 800);
			primaryStage.setScene(scene);
			primaryStage.show();

		

			
		}
    	   
	});
       printt.setOnAction(new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent arg0) {
			BorderPane o = new BorderPane();
			o.setStyle("-fx-background-color: MOCCASIN;");
			GridPane g = new GridPane();
			TextArea area1 = new TextArea();
			Label name= new Label("Department Name:");
			TextField bt=new TextField();
			name.setFont(Font.font(15));
			name.setFont(Font.font(null, FontWeight.BOLD, name.getFont().getSize()));
			g.add(name, 0, 0);
			g.add(bt, 1, 0);
			
			area1.setPrefWidth(1000);
			area1.setPrefHeight(500);
			area1.setFont(Font.font(15));
			area1.setFont(Font.font(null, FontWeight.BOLD, area1.getFont().getSize()));
			g.add(area1, 0, 2);
			g.setAlignment(Pos.CENTER);
			g.setHgap(5);
			g.setVgap(20);
			o.setCenter(g);
			Image image33 = new Image("back.png");
			Button b2 = new Button("", new ImageView(image33));
			b2.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					
					primaryStage.setScene(scene);

				}

			});
			btt.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					//AVLNode t=m.search(bt.getText());
					TNode t=v.find(bt.getText());
					if(t!=null) {
						
						area1.setText(t.data.m.printHashTable());
					}else
						{
							area1.setText("Missing Department");
						}
					
					
					
					}
					
				
				
			});
			HBox h=new HBox();
			h.getChildren().addAll(b2,btt);
			h.setAlignment(Pos.CENTER);
			o.setBottom(h);
			Scene scene = new Scene(o, 1550, 800);
			primaryStage.setScene(scene);
			primaryStage.show();

		

			
		}
    	   
	});
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
