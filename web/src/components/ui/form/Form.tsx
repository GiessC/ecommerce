import {FieldValues, FormProvider, SubmitHandler, useForm, UseFormProps, UseFormReturn} from "react-hook-form";
import {zodResolver} from "@hookform/resolvers/zod";
import {z, ZodType} from "zod";
import {ReactNode} from "react";

type FormProps<TFormValues extends FieldValues, Schema> = {
    onSubmit: SubmitHandler<TFormValues>;
    schema: Schema;
    className?: string;
    children: (methods: UseFormReturn<TFormValues>) => ReactNode;
    options?: UseFormProps<TFormValues>;
    id?: string;
};

export default function Form<
    Schema extends ZodType<any, any, any>,
    TFormValues extends FieldValues = z.infer<Schema>,
>({
      onSubmit,
      children,
      className,
      options,
      id,
      schema,
  }: FormProps<TFormValues, Schema>) {
    const form = useForm({ ...options, resolver: zodResolver(schema) });

    return (
        <FormProvider {...form}>
            <form
                className={`space-y-6 ${className}`}
                onSubmit={form.handleSubmit(onSubmit)}
                id={id}
            >
                {children(form)}
            </form>
        </FormProvider>
    );
}
