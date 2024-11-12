"use client";

import { zodResolver } from "@hookform/resolvers/zod";
import { useForm } from "react-hook-form";
import * as z from "zod";
import { Input } from "@/components/ui/input";
import { Textarea } from "@/components/ui/textarea";
import { Button } from "@/components/ui/button";
import { Form, FormControl, FormField, FormItem, FormLabel, FormMessage } from "@/components/ui/form";

const formSchema = z.object({
  user: z.string().optional(),
  contact: z.string().email("올바른 이메일 형식이 아닙니다"),
  description: z.string().optional(),
  data: z.string().min(1, "요청하시는 데이터를 입력해주세요"),
  purpose: z.string().min(1, "활용목적을 입력해주세요"),
  additionalInfo: z.string().optional(),
  link: z.string().url("올바른 주소 형식이 아닙니다"),
});

type FormValues = z.infer<typeof formSchema>;

export function DataRequest() {
  const form = useForm<FormValues>({
    resolver: zodResolver(formSchema),
    defaultValues: {
      user: "",
      contact: "",
      description: "",
      data: "",
      purpose: "",
      additionalInfo: "",
      link: "",
    },
  });

  function onSubmit(values: FormValues) {
    console.log(values);
  }

  return (
    <Form {...form}>
      <form onSubmit={form.handleSubmit(onSubmit)} className="space-y-4">
        <FormField
          control={form.control}
          name="user"
          render={({ field }) => (
            <FormItem>
              <FormLabel>이름</FormLabel>
              <FormControl>
                <Input placeholder="이름을 입력하세요." {...field} />
              </FormControl>
              <FormMessage />
            </FormItem>
          )}
        />

        <FormField
          control={form.control}
          name="contact"
          render={({ field }) => (
            <FormItem>
              <FormLabel>
                답변받을 이메일<span className="text-red-500">*</span>
              </FormLabel>
              <FormControl>
                <Input type="email" placeholder="이메일을 입력하세요." {...field} />
              </FormControl>
              <FormMessage />
            </FormItem>
          )}
        />

        <FormField
          control={form.control}
          name="description"
          render={({ field }) => (
            <FormItem>
              <FormLabel>소속</FormLabel>
              <FormControl>
                <Input placeholder="소속을 입력하세요." {...field} />
              </FormControl>
              <FormMessage />
            </FormItem>
          )}
        />

        <FormField
          control={form.control}
          name="data"
          render={({ field }) => (
            <FormItem>
              <FormLabel>
                공공데이터 명칭<span className="text-red-500">*</span>
              </FormLabel>
              <FormControl>
                <Textarea placeholder="공공데이터 이름을 입력하세요." {...field} />
              </FormControl>
              <FormMessage />
            </FormItem>
          )}
        />

        <FormField
          control={form.control}
          name="link"
          render={({ field }) => (
            <FormItem>
              <FormLabel>
                해당 공공데이터 링크<span className="text-red-500">*</span>
              </FormLabel>
              <FormControl>
                <Input type="url" placeholder="공공데이터 링크를." {...field} />
              </FormControl>
              <FormMessage />
            </FormItem>
          )}
        />

        <FormField
          control={form.control}
          name="purpose"
          render={({ field }) => (
            <FormItem>
              <FormLabel>
                활용 목적<span className="text-red-500">*</span>
              </FormLabel>
              <FormControl>
                <Input placeholder="활용목적을 입력하세요." {...field} />
              </FormControl>
              <FormMessage />
            </FormItem>
          )}
        />

        <FormField
          control={form.control}
          name="additionalInfo"
          render={({ field }) => (
            <FormItem>
              <FormLabel>기타 요청사항</FormLabel>
              <FormControl>
                <Input placeholder="기타요청사항을 입력하세요." {...field} />
              </FormControl>
              <FormMessage />
            </FormItem>
          )}
        />

        <div className="flex justify-end">
          <Button type="submit">제출하기</Button>
        </div>
      </form>
    </Form>
  );
}
