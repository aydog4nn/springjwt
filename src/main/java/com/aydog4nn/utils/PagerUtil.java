package com.aydog4nn.utils;

import lombok.experimental.UtilityClass;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@UtilityClass
public class PagerUtil {


        public boolean isNullOrEmpty(String value){
            return value==null || value.trim().length() == 0;
        }


        public Pageable toPageable(RestPageableRequest request){
            if (!isNullOrEmpty(request.getColumnName())){
                Sort sortBy = request.isAsc() ?  Sort.by(Sort.Direction.ASC, request.getColumnName()) :
                        Sort.by(Sort.Direction.DESC, request.getColumnName());


                  return PageRequest.of(request.getPageNumber(), request.getPageSize(),sortBy);
            }
            return PageRequest.of(request.getPageNumber(), request.getPageSize());
        }

}
