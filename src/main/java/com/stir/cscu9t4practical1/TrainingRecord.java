// An implementation of a Training Record as an ArrayList
package com.stir.cscu9t4practical1;




import java.util.*;


public class TrainingRecord {
    private List<Entry> tr;
    
    public TrainingRecord() {
        tr = new ArrayList<Entry>();
    } //constructor
    
    // add a record to the list
   public void addEntry(Entry e){
       tr.add(e);    
   } // addClass
   
   // look up the entry of a given day and month
   public String lookupEntry (int d, int m, int y) {
       ListIterator<Entry> iter = tr.listIterator();
       String result = "No entries found";
       while (iter.hasNext()) {
          Entry current = iter.next();
          if (current.getDay()==d && current.getMonth()==m && current.getYear()==y) 
             result = current.getEntry();
        }
       return result;
   } // lookupEntry
   
   // look up all the entries of a given day, month and year
   public String lookupEntries (int d, int m, int y) {
       ListIterator<Entry> iter = tr.listIterator();
       String result = "";
       while (iter.hasNext()) {
           Entry current = iter.next();
           if (current.getDay() == d && current.getMonth() == m && current.getYear() == y)
               result += current.getEntry();
       }
       if (result.isEmpty())
           result = "No entries found";
       return result;
   } // lookupEntries
   
   // check to see if an entry already exists for given name, day, month and year
   public boolean checkEntryExists(String n, int d, int m, int y) {
       ListIterator<Entry> iter = tr.listIterator();
       while (iter.hasNext()) {
           Entry current = iter.next();
           if (current.getName().equalsIgnoreCase(n) && current.getDay() == d && current.getMonth() == m && current.getYear() == y)
               return true;
       }
       return false;
   }
   
   // remove entry of given name, day, month and year
   public String removeEntry(String n, int d, int m, int y) {
       ListIterator<Entry> iter = tr.listIterator();
       while (iter.hasNext()) {
           Entry current = iter.next();
           if (current.getName().equalsIgnoreCase(n) && current.getDay() == d && current.getMonth() == m && current.getYear() == y) {
               iter.remove();
               return "Entry removed";
           }
       }
       return "No entry found";
   }
   
   // Count the number of entries
   public int getNumberOfEntries(){
       return tr.size();
   }
   // Clear all entries
   public void clearAllEntries(){
       tr.clear();
   }
   
} // TrainingRecord