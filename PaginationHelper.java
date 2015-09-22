import java.util.List;

public class PaginationHelper<I> {
  
  private List<I> collection;
  private int itemsPerPage;
  private int maxPageIndex;
  
  /**
   * The constructor takes in an array of items and a integer indicating how many
   * items fit within a single page
   */
  public PaginationHelper(List<I> collection, int itemsPerPage) {
    this.collection = collection;
    this.itemsPerPage = itemsPerPage;
    maxPageIndex = itemCount()/itemsPerPage;
  }
  
  /**
   * returns the number of items within the entire collection
   */
  public int itemCount() {
    return collection.size();
  }
  
  /**
   * returns the number of pages
   */
  public int pageCount() {
    return maxPageIndex + 1;
  }
  
  /**
   * returns the number of items on the current page. page_index is zero based.
   * this method should return -1 for pageIndex values that are out of range
   */
  public int pageItemCount(int pageIndex) {
    if(pageIndex>maxPageIndex || pageIndex<0)
      return -1;
    return pageIndex!=maxPageIndex
      ? itemsPerPage
      : itemCount()%itemsPerPage;
  }
  
  /**
   * determines what page an item is on. Zero based indexes
   * this method should return -1 for itemIndex values that are out of range
   */
  public int pageIndex(int itemIndex) {
    if(itemIndex > itemCount() || itemIndex < 0 || itemCount()<=0)
      return -1;
    return itemIndex / itemsPerPage;
  }
}
