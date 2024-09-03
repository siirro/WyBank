package com.wybank.dto;

import java.util.List;

public class PageResponseDTO<E> {

    private List<E> dtolist;
    private List<Integer> pageNumList;
    private PageRequestDTO pageRequestDTO;
    private boolean prev, next;
    private int totalCount, prevPage, nextPage, totalPage, currentPage;

    public PageResponseDTO(List<E> dtoList, PageRequestDTO pageRequestDTO, long totalCount) {
        this.dtolist = dtoList;
        this.pageRequestDTO = pageRequestDTO;
        this.totalCount = (int) totalCount;

        // 끝페이지 계산 end
        int end = (int)(Math.ceil(pageRequestDTO.getPage() / 10.0))*10;
        int start = end - 9;

        // 마지막 페이지
        int last = (int)(Math.ceil(totalCount/(double)pageRequestDTO.getSize()));
        end = end > last ? last : end;
        this.prev = start > 1;
        this.next = totalCount > end * pageRequestDTO.getSize();

    }
}
