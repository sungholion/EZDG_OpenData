// types/form.ts
import * as z from "zod";

export const formSchema = z.object({
  name: z.string().min(1, "이름을 입력해 주세요").max(20, "이름은 최대 20자까지 가능합니다."),
  email: z.string().email("올바른 이메일 형식이 아닙니다"),
  association: z.string().max(30, "소속은 최대 30자까지 가능합니다.").optional(),
  publicDataName: z.string().min(1, "요청하시는 데이터를 입력해주세요").max(50, "공공데이터 명칭은 최대 50자까지 가능합니다."),
  publicDataLink: z.string().url("올바른 주소 형식이 아닙니다"),
  publicDataType: z.string().min(1, "공공데이터 타입을 입력해주세요").max(10, "공공데이터 타입은 최대 10자까지 가능합니다."),
  purpose: z.string().min(1, "공공데이터 활용 목적을 입력해주요").max(50, "활용 목적은 최대 50자까지 가능합니다."),
  additionalRequest: z.string().max(100, "기타 요청사항은 최대 100자까지 가능합니다.").optional()
});

export type FormValues = z.infer<typeof formSchema>;