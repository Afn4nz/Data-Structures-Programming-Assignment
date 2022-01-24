public class Album {

    private String name;/*unique*/
    private String condition;
    private PhotoManager manager;

    // Constructor
    public Album(String name, String condition, PhotoManager manager) {

        this.name = name;
        this.condition = condition;
        this.manager = manager;
    }

    // Return the name of the album
    public String getName() {
        return name;
    }

    // Return the condition associated with the album
    public String getCondition() {
        return condition;
    }

    // Return the manager
    public PhotoManager getManager() {
        return manager;
    }

    // Return all photos that satisfy the album condition
    public LinkedList<Photo> getPhotos() {

        LinkedList<Photo> emptyLL = new LinkedList<>();// ro return it if condition is wrong 

        // if(condition==null) return emptyLL; no need
        //// to extract tags from condition ////
        String[] condTags = condition.split(" AND ");

        //first sol.
        //// to get all photos ///
           manager.getAllPhotos().findFirst(); 
            LinkedList<Photo> allPhotos=new LinkedList<>();// normal all photos
            for(int i=0 ; i<manager.getAllPhotos().size(); i++)
            {
                 allPhotos.insert(manager.getAllPhotos().retrieve());
                 
                 if(i==manager.getAllPhotos().size()-1)
                     break;
                 manager.getAllPhotos().findNext();   }   
             
           BST<LinkedList<Photo>> bst =manager.getPhotos(); //whole tree 
        
        //second sol.
        /*
        BST<LinkedList<Photo>> bst = manager.getPhotos(); //whole tree
        LinkedList<LinkedList<Photo>> llllP = bst.getAllPhotos(); // linked of linked 
        if (llllP.empty()) {
            return emptyLL; // tree is empty 
        }
        LinkedList<Photo> llP = new LinkedList<Photo>();  // linked of photo reption
        LinkedList<Photo> allPhotos = new LinkedList<Photo>();// without reption

        //to move photos from Linked<Linked<Photo>> to linked<Photo>
        llllP.findFirst();
        for (int i = 0; i < llllP.size(); i++) {
            llP.insert(llllP.retrieve().retrieve());

            if (i == llllP.size() - 1) {
                break;
            }
            
            llllP.findNext();
        }
        //to move photos without reption
        llP.findFirst();
        for (int i = 0; i < llP.size(); i++) {
            if (!isPhotoExists(allPhotos, llP.retrieve())) {
                allPhotos.insert(llP.retrieve());
            }

            if (i == llP.size() - 1) {
                break;
            }

            llP.findNext();

        }*/ 

        //   bst.DisplayInvertedIndexPhotos(allPhotos);
        ///////  ic case its EMPTY ///////////
        if (condition.equals("")) {
            return allPhotos;
        }
        ///////                    ////////////

        LinkedList<Photo> tagPhotos = new LinkedList<Photo>();   //linkedlist of photos for specifc tag 

        for (int i = 0; i < condTags.length; i++) {

            if (bst.findKey(condTags[i])) // search for tag 
            {
                tagPhotos = bst.retrieve(); //return tag photos list
            } else {
                return emptyLL;   //// in case condition was wrong ///
            }
            allPhotos.findFirst();
            while (!allPhotos.last()) {
                if (!isPhotoExists(tagPhotos, allPhotos.retrieve())) {
                    allPhotos.remove();
                } else {
                    allPhotos.findNext();
                }

            }// end inner for

            if (!isPhotoExists(tagPhotos, allPhotos.retrieve())) {
                allPhotos.remove();
            }
        } // outer loop

        return allPhotos;
    }

    private boolean isPhotoExists(LinkedList<Photo> L, Photo p) {
        if (L.empty()) {
            return false;
        }

        L.findFirst(); //to start from the begienig
        for (int i = 0; i < L.size(); i++) {

            if (L.retrieve().getPath().equals(p.getPath())) {
                return true;
            }

            if (i == L.size() - 1) // to avoid puting current on null
            {
                return false;
            }
            L.findNext();
        }

        return false;
    }

    // Return the number of tag comparisons used to find all photos of the album
    public int getNbComps() {

        int NbComps = 0;
        if (condition.equals("")) {
            return 0;
        }

        BST<LinkedList<Photo>> bst = manager.getPhotos();

        String[] condTags = condition.split(" AND ");
        for (int i = 0; i < condTags.length; i++) {

            NbComps += bst.countNbComps(condTags[i]);
        }

        return NbComps;
    }

}
