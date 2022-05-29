package com.example.application.domain;
import com.example.application.enums.ContactDetail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParentContact {
    private ContactDetail fixed;
    private ContactDetail mobile;
    private ContactDetail email;
}
