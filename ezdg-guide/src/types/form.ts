// types/form.ts
import * as z from "zod";

export const formSchema = z.object({
  name: z.string().min(1, "이름을 입력해 주세요"),
  email: z.string().email("올바른 이메일 형식이 아닙니다"),
  association: z.string().optional(),
  publicDataName: z.string().min(1, "요청하시는 데이터를 입력해주세요"),
  publicDataLink: z.string().url("올바른 주소 형식이 아닙니다"),
  publicDataType: z.string().min(1, "공공데이터 타입을 입력해주세요"),
  purpose: z.string().min(1, "공공데이터 활용 목적을 입력해주요"),
  additionalRequest: z.string().optional(),
});

export type FormValues = z.infer<typeof formSchema>;