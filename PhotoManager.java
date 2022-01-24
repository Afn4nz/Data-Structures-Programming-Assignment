/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author PC
 */
public class PhotoManager {
    BST<LinkedList<Photo>> invertedIndex;
   
	public PhotoManager(){
            invertedIndex= new BST<LinkedList<Photo>>();
        }
        
	// Add a photo
	public void addPhoto(Photo p){
            int size=0;
      
             LinkedList<String> photoTags= p.getTags(); // get all tags
              photoTags.findFirst(); // to start from begining 
                    
             while(!photoTags.last()){
                 size++;
             }
             size++;
             
             for(int i=0 ; i< size ; i++){
              if(!invertedIndex.findKey(photoTags.retrieve())) // check first if k not exist
            { 
               LinkedList<Photo> photos = new LinkedList<Photo>(); // every key(tag) has List
               photos.insert(p);
              invertedIndex.insert(photoTags.retrieve(),photos);
               photoTags.findNext();
             }
             else
                 invertedIndex.retrieve().insert(p);  
             }
        }
   
        
	// Delete a photo
	public void deletePhoto(String path){
            
        }
        
	// Return the inverted index of all managed photos
	public BST<LinkedList<Photo>> getPhotos(){
            return invertedIndex;
        }
        
     
}
