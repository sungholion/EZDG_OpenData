import api from "@/lib/axios";
import { FormValues } from "@/types/form";

export const dataRequestAPI = {
  requestData: async (formData: FormValues) => {
    const response = await api.post("/admin/users/dataApply", formData)
    return response.data;
  }
}
