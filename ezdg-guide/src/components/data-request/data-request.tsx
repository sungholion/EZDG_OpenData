"use client";

import { zodResolver } from "@hookform/resolvers/zod";
import { useForm } from "react-hook-form";
import { useState } from "react";
import { useToast } from "@/hooks/use-toast";
import { dataRequestAPI } from "@/app/api/data-request";
import { Input } from "@/components/ui/input";
import { Textarea } from "@/components/ui/textarea";
import { Button } from "@/components/ui/button";
import { Form, FormControl, FormField, FormItem, FormLabel, FormMessage } from "@/components/ui/form";
import { formSchema, type FormValues } from "@/types/form";

export function DataRequest() {
  const [isSubmitting, setIsSubmitting] = useState(false);
  const { toast } = useToast();

  const form = useForm<FormValues>({
    resolver: zodResolver(formSchema),
    defaultValues: {
      name: "",
      email: "",
      association: "",
      publicDataName: "",
      publicDataLink: "",
      publicDataType: "",
      purpose: "",
      additionalRequest: "",
    },
  });

  async function onSubmit(values: FormValues) {
    try {
      setIsSubmitting(true);

      await dataRequestAPI.requestData(values);

      toast({
        title: "요청완료",
        description: "데이터 요청이 성공적으로 전송되었습니다.",
        variant: "default",
      });

      form.reset();
    } catch (error) {
      console.error("Error submitting from::", error);

      toast({
        title: "요청 실패",
        description: "데이터 요청 중 오류가 발생했습니다. 다시 시도해 주세요.",
        variant: "destructive",
      });
    } finally {
      setIsSubmitting(false);
    }
  }

  return (
    <Form {...form}>
      <form onSubmit={form.handleSubmit(onSubmit)} className="space-y-4">
        <FormField
          control={form.control}
          name="name"
          render={({ field }) => (
            <FormItem>
              <FormLabel>
                이름<span className="text-red-500"> *</span>
              </FormLabel>
              <FormControl>
                <Input placeholder="이름을 입력하세요." {...field} />
              </FormControl>
              <FormMessage />
            </FormItem>
          )}
        />

        <FormField
          control={form.control}
          name="email"
          render={({ field }) => (
            <FormItem>
              <FormLabel>
                답변받을 이메일<span className="text-red-500"> *</span>
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
          name="association"
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
          name="publicDataName"
          render={({ field }) => (
            <FormItem>
              <FormLabel>
                공공데이터 명칭<span className="text-red-500"> *</span>
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
          name="publicDataLink"
          render={({ field }) => (
            <FormItem>
              <FormLabel>
                해당 공공데이터 링크<span className="text-red-500"> *</span>
              </FormLabel>
              <FormControl>
                <Input type="url" placeholder="공공데이터 링크를 입력하세요." {...field} />
              </FormControl>
              <FormMessage />
            </FormItem>
          )}
        />

        <FormField
          control={form.control}
          name="publicDataType"
          render={({ field }) => (
            <FormItem>
              <FormLabel>
                해당 공공데이터 타입 (예: CSV, XML, OpenAPI... 등)<span className="text-red-500"> *</span>
              </FormLabel>
              <FormControl>
                <Input placeholder="공공데이터 타입을 입력하세요." {...field} />
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
                활용 목적<span className="text-red-500"> *</span>
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
          name="additionalRequest"
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
          <Button type="submit" disabled={isSubmitting} className="min-w-[100px]">
            {isSubmitting ? (
              <span className="flex items-center gap-2">
                <svg
                  className="animate-spin h-4 w-4"
                  xmlns="http://www.w3.org/2000/svg"
                  fill="none"
                  viewBox="0 0 24 24">
                  <circle className="opacity-25" cx="12" cy="12" r="10" stroke="currentColor" strokeWidth="4" />
                  <path className="opacity-75" fill="currentColor" d="M4 12a8 8 0 018-8V0C5.373 0 0 5.373 0 12h4z" />
                </svg>
                처리중 ...
              </span>
            ) : (
              "요청하기"
            )}
          </Button>
        </div>
      </form>
    </Form>
  );
}
