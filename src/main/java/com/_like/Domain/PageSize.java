package com._like.Domain;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageSize {


    private int  currentPage;
    private int  nextPage;
    private int prevPage;
    private int lastPage;
    private int totalPage;
    private int totalCount;
    private Integer limitSize;

    public PageSize(int totalCount,int currentPage,Integer limitSize){
        this.currentPage = currentPage;
        this.totalCount = totalCount;
        this.limitSize = limitSize;
        this.totalPage = (totalCount / limitSize > 1) && (totalCount % limitSize == 0) ? totalCount/limitSize : (totalCount/limitSize + 1);
        this.prevPage = currentPage - 1 > 1 ? (currentPage - 1) : 1;
        this.nextPage = (currentPage + 1 < totalPage) ? (currentPage + 1) : totalPage;
        this.lastPage = totalPage;
    }

}
