/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author PC
 */
public class Photo {
        String path;
        LinkedList<String> tags; 
        
	// Constructor
	public Photo(String path, LinkedList<String> tags){
            this.path=path;
            this.tags=tags;  
        }
        
	// Return the path (full file name) of the photo. A photo is uniquely identified by its path.
	public String getPath(){
            return path;
        }
        
	// Return all tags associated with the photo
	public LinkedList<String> getTags(){
            return tags;
        }
        
        // helper method
        public void displayPhoto(){
            System.out.println("Photo info:");
            System.out.print("Path: "+path);
            System.out.print(" Tags: ");
            tags.display();
      
           
            
        }
        
        
}
