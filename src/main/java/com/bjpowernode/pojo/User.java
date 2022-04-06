package com.bjpowernode.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wjs
 * @create 2022-02-22 10:04
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer uid;
    private String uname;
    private String upass;
    private Integer ustaus;
    private Integer ulevel;
    private Integer score;
}
